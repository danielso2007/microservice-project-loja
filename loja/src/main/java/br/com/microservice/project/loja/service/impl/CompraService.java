package br.com.microservice.project.loja.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.microservice.project.loja.dto.CompraDTO;
import br.com.microservice.project.loja.entity.Compra;
import br.com.microservice.project.loja.feign.IFornecedorController;
import br.com.microservice.project.loja.feign.dto.InfoFornecedorDTO;
import br.com.microservice.project.loja.feign.dto.InfoPedidoDTO;
import br.com.microservice.project.loja.repository.CompraRepository;
import br.com.microservice.project.loja.service.ICompraService;

@Transactional(readOnly = true)
@Service
public class CompraService implements ICompraService {

	private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);
	
	@Autowired
	private IFornecedorController fornecedorController;
	
	@Autowired
	private CompraRepository compraRepository;

	@Autowired
	private DiscoveryClient discoveryClient;

	@Override
	public Compra realizarCompra(CompraDTO compraDTO) {
		LOG.info("Realizando pedido...");
		
		ResponseEntity<List<InfoFornecedorDTO>> response = fornecedorController.info(compraDTO.getEndereco().getEstado());

		discoveryClient.getInstances("fornecedor").stream().forEach(fornecedor -> {
			System.out.println(fornecedor.getPort());
		});

		List<InfoFornecedorDTO> list = response.getBody();
		
		for (InfoFornecedorDTO obj : list) {
			System.out.println(obj);
		}
		
		InfoPedidoDTO infoPedidoDTO = fornecedorController.realizaPedido(compraDTO.getItens()).getBody();

		return salvarPedido(infoPedidoDTO, compraDTO);
	}
	
	private Compra salvarPedido(InfoPedidoDTO infoPedidoDTO, CompraDTO compraDTO) {
		Compra compraSalva = new Compra();
		compraSalva.setPedidoId(infoPedidoDTO.getId());
		compraSalva.setTempoDePreparo(infoPedidoDTO.getTempoDePreparo());
		compraSalva.setEnderecoDestino(compraDTO.getEndereco().toString());
		
		compraSalva = save(compraSalva);
		
		LOG.info("Pedido finalizado.");
		
		return compraSalva;
	}
	
	@Transactional(readOnly = false)
	@Override
	public Compra save(Compra compra) {
		LOG.info("Salvando compra...");
		compra = compraRepository.save(compra);
		LOG.info("Compra salva.");
		return compra;
	}

	@Override
	public Compra getById(Long id) {
		Optional<Compra> opt = compraRepository.findById(id);
		if (opt.isEmpty()) {
			throw new EntityNotFoundException();
		}
		return opt.get();
	}

}
