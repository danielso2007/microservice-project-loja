package br.com.microservice.project.transportador.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.microservice.project.transportador.dto.EntregaDTO;
import br.com.microservice.project.transportador.dto.VoucherDTO;
import br.com.microservice.project.transportador.entity.Entrega;
import br.com.microservice.project.transportador.repository.EntregaRepository;

@Transactional(readOnly = true)
@Service
public class EntregaService implements IEntregaRepository {
	
	private static final Logger LOG = LoggerFactory.getLogger(EntregaService.class);
	
	@Autowired
	private EntregaRepository repository;

	@Transactional(readOnly = false)
	public VoucherDTO reservaEntrega(EntregaDTO pedidoDTO) {
		LOG.info("Reserva de entrega...");
		
		Entrega entrega = new Entrega();
		entrega.setDataParaBusca(pedidoDTO.getDataParaEntrega());
		entrega.setPrevisaoParaEntrega(pedidoDTO.getDataParaEntrega().plusDays(1l));
		entrega.setEnderecoDestino(pedidoDTO.getEnderecoDestino());
		entrega.setEnderecoOrigem(pedidoDTO.getEnderecoOrigem());
		entrega.setPedidoId(pedidoDTO.getPedidoId());
		
		save(entrega);
		
		VoucherDTO voucher = new VoucherDTO();
		voucher.setNumero(entrega.getId());
		voucher.setPrevisaoParaEntrega(entrega.getPrevisaoParaEntrega());
		
		LOG.info("Retornando voucher.");
		
		return voucher;
	}
	
	@Transactional(readOnly = false)
	public Entrega save(Entrega entrega) {
		LOG.info("Salvando entrega.");
		return repository.save(entrega);
	}

}
