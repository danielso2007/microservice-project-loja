package br.com.microservice.project.loja.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.microservice.project.loja.dto.RealizarCompraDTO;
import br.com.microservice.project.loja.entity.Compra;
import br.com.microservice.project.loja.entity.CompraStatus;
import br.com.microservice.project.loja.feign.IEntregaController;
import br.com.microservice.project.loja.feign.IFornecedorController;
import br.com.microservice.project.loja.feign.dto.InfoEntregaDTO;
import br.com.microservice.project.loja.feign.dto.InfoFornecedorDTO;
import br.com.microservice.project.loja.feign.dto.InfoPedidoDTO;
import br.com.microservice.project.loja.feign.dto.InfoVoucherDTO;
import br.com.microservice.project.loja.repository.CompraRepository;
import br.com.microservice.project.loja.service.ICompraService;

@Transactional(readOnly = true)
@Service
public class CompraService implements ICompraService {

	private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);

	@Autowired
	private IFornecedorController fornecedorController;

	@Autowired
	private IEntregaController entregaController;

	@Autowired
	private CompraRepository compraRepository;

	@Autowired
	private DiscoveryClient discoveryClient;

	@HystrixCommand(threadPoolKey = "reprocessarThreadPool")
	@Override
	public Compra reprocessar(Long id) {
		Optional<Compra> opt = compraRepository.findById(id);
		if (opt.isEmpty()) {
			throw new EntityNotFoundException();
		}
		Compra compra = opt.get();

		if (CompraStatus.RECEBIDO.equals(compra.getStatus())) {
			// Realizar pedido
			// Realizar reserva de entrega
		} else if (CompraStatus.PREDIDO_REALIZADO.equals(compra.getStatus())) {
			// Realizar reserva de entrega
		} else if (CompraStatus.RESERVA_ENTREGA_REALIZADA.equals(compra.getStatus())) {
			// Informar que entrega já reservada.
		}

		return compra;
	}

	@HystrixCommand(threadPoolKey = "cancelarThreadPool")
	@Override
	public Compra cancelar(Long id) {
		Optional<Compra> opt = compraRepository.findById(id);
		if (opt.isEmpty()) {
			throw new EntityNotFoundException();
		}
		Compra compra = opt.get();
		compra.setStatus(CompraStatus.CANCELADO);
		if (CompraStatus.PREDIDO_REALIZADO.equals(compra.getStatus())) {
			// Cancelar pedido no fornecedor
			cancelarComFornecedor(compra);
		} else if (CompraStatus.RESERVA_ENTREGA_REALIZADA.equals(compra.getStatus())) {
			// Cancelar pedido no fornecedor
			cancelarComFornecedor(compra);
			// Cancelar entrega
			cancelarComTransportadora(compra);
		}
		return save(compra);
	}

	private void cancelarComTransportadora(Compra compra) {
		// Cancelar entrega
		LOG.info("Cancelando entrega com transportadora...");
	}

	private void cancelarComFornecedor(Compra compra) {
		// Cancelar pedido no fornecedor
		LOG.info("Cancelando pedido no fornecedor...");
	}

	private Compra receber(RealizarCompraDTO realizarCompraDTO) {
		Compra compraSalva = new Compra();
		compraSalva.setEnderecoDestino(realizarCompraDTO.getEndereco().enderecoCompleto());
		compraSalva.setStatus(CompraStatus.RECEBIDO);
		LOG.info("Pedido recebido.");
		return save(compraSalva);
	}

	private InfoFornecedorDTO obterFornecedor(RealizarCompraDTO realizarCompraDTO) {
		ResponseEntity<List<InfoFornecedorDTO>> fornecedorList = fornecedorController
				.info(realizarCompraDTO.getEndereco().getEstado());

		discoveryClient.getInstances("fornecedor").stream().forEach(fornecedor -> {
			System.out.println(fornecedor.getPort());
		});
		List<InfoFornecedorDTO> list = fornecedorList.getBody();
		// Aqui tem que pegar o fornecedor disponível. Eles são do estado do pedido de
		// compra.
		for (InfoFornecedorDTO obj : list) {
			System.out.println(obj);
		}

		return list.get(0);
	}

	private Compra realizarPedido(Compra compraSalva, RealizarCompraDTO realizarCompraDTO) {
		// Microservice fornecedor.
		InfoPedidoDTO infoPedidoDTO = fornecedorController.realizaPedido(realizarCompraDTO.getItens()).getBody();
		compraSalva.setPedidoId(infoPedidoDTO.getId());
		compraSalva.setTempoDePreparo(infoPedidoDTO.getTempoDePreparo());
		compraSalva.setStatus(CompraStatus.PREDIDO_REALIZADO);
		LOG.info("Pedido realizado.");
		return save(compraSalva);
	}

	private InfoEntregaDTO criarEntrega(InfoFornecedorDTO infoFornecedorDTO, Compra compraSalva,
			RealizarCompraDTO realizarCompraDTO) {
		InfoEntregaDTO entregaDTO = new InfoEntregaDTO();
		entregaDTO.setDataParaEntrega(LocalDate.now().plusDays(compraSalva.getTempoDePreparo()));
		entregaDTO.setEnderecoOrigem(infoFornecedorDTO.getEndereco());
		entregaDTO.setEnderecoDestino(realizarCompraDTO.getEndereco().enderecoCompleto());
		entregaDTO.setPedidoId(compraSalva.getPedidoId());
		return entregaDTO;
	}

	private Compra criarVoucher(Compra compraSalva, InfoEntregaDTO entregaDTO) {
		InfoVoucherDTO infoVoucherDTO = entregaController.reservaEntrega(entregaDTO);
		compraSalva.setDataParaEntrega(infoVoucherDTO.getPrevisaoParaEntrega());
		compraSalva.setVoucher(infoVoucherDTO.getNumero());
		compraSalva.setStatus(CompraStatus.RESERVA_ENTREGA_REALIZADA);
		LOG.info("Pedido reserva de entrega realizada.");
		return save(compraSalva);
	}

	@HystrixCommand(threadPoolKey = "realizaCompraThreadPool", fallbackMethod = "realizaCompraFallback")
	@Override
	public Compra realizarCompra(RealizarCompraDTO realizarCompraDTO) {
		LOG.info("Receber pedido...");
		Compra compraSalva = receber(realizarCompraDTO);
		realizarCompraDTO.setCompraId(compraSalva.getId());

		LOG.info("Realizar pedido...");
		compraSalva = realizarPedido(compraSalva, realizarCompraDTO);

		// Apenas teste de Hystrix
		// if (1 == 1) throw new RuntimeException();

		// Microservice transportador.
		InfoFornecedorDTO infoFornecedorDTO = obterFornecedor(realizarCompraDTO);
		LOG.info("Preparar entrega...");
		InfoEntregaDTO entregaDTO = criarEntrega(infoFornecedorDTO, compraSalva, realizarCompraDTO);

		LOG.info("Criar voucher...");
		compraSalva = criarVoucher(compraSalva, entregaDTO);

		return compraSalva;
	}

	@Override
	public Compra realizaCompraFallback(@Valid RealizarCompraDTO compra) {
		if (compra.getCompraId() != null) {
			return compraRepository.findById(compra.getCompraId()).orElse(new Compra());
		}
		return new Compra();
	}

	@Transactional(readOnly = false)
	@Override
	public Compra save(Compra compra) {
		LOG.info("Salvando compra...");
		compra = compraRepository.save(compra);
		LOG.info("Compra salva.");
		return compra;
	}

	@HystrixCommand(threadPoolKey = "getByIdThreadPool")
	@Override
	public Compra getById(Long id) {
		Optional<Compra> opt = compraRepository.findById(id);
		if (opt.isEmpty()) {
			throw new EntityNotFoundException();
		}
		return opt.get();
	}

}
