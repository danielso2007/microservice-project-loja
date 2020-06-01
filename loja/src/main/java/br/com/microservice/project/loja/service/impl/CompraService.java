package br.com.microservice.project.loja.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.microservice.project.loja.dto.CompraDTO;
import br.com.microservice.project.loja.entity.Compra;
import br.com.microservice.project.loja.feign.IFornecedorController;
import br.com.microservice.project.loja.feign.dto.InfoFornecedorDTO;
import br.com.microservice.project.loja.feign.dto.InfoPedidoDTO;
import br.com.microservice.project.loja.service.ICompraService;

@Service
public class CompraService implements ICompraService {

	private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);
	
	@Autowired
	private IFornecedorController fornecedorController;

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
		
		InfoPedidoDTO infoPedidoDTO = fornecedorController.realizaPedido(compraDTO.getItens());
		Compra compraSalva = new Compra();
		compraSalva.setPedidoId(infoPedidoDTO.getId());
		compraSalva.setTempoDePreparo(infoPedidoDTO.getTempoDePreparo());
		compraSalva.setEnderecoDestino(compraDTO.getEndereco().toString());
		
		LOG.info("Pedido finalizado.");
		
		return compraSalva;
	}

}
