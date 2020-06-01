package br.com.microservice.project.fornecedor.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.microservice.project.fornecedor.dto.ItemDoPedidoDTO;
import br.com.microservice.project.fornecedor.entity.Pedido;
import br.com.microservice.project.fornecedor.entity.PedidoItem;
import br.com.microservice.project.fornecedor.entity.Produto;
import br.com.microservice.project.fornecedor.repository.PedidoRepository;
import br.com.microservice.project.fornecedor.repository.ProdutoRepository;
import br.com.microservice.project.fornecedor.service.IPedidoService;

@Transactional(readOnly = true)
@Service
public class PedidoService implements IPedidoService {

	private static final Logger LOG = LoggerFactory.getLogger(PedidoService.class);
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Transactional(readOnly = false)
	@Override
	public Pedido realizaPedido(List<ItemDoPedidoDTO> itens) {
		LOG.info("Realizando pedido...");
		if (itens == null) {
			return null;
		}

		List<PedidoItem> pedidoItens = toPedidoItem(itens);
		Pedido pedido = new Pedido(pedidoItens);
		pedido.setTempoDePreparo(itens.size());
		
		LOG.info("Pedido finalizado.");
		return pedidoRepository.save(pedido);
	}

	@Override
	public Pedido getPedidoPorId(Long id) {
		LOG.info("Obtendo pedido: " + id);
		return this.pedidoRepository.findById(id).orElse(new Pedido());
	}

	private List<PedidoItem> toPedidoItem(List<ItemDoPedidoDTO> itens) {
		LOG.info("Obtendi itens de pedido.");
		
		List<Long> idsProdutos = itens.stream().map(item -> item.getId()).collect(Collectors.toList());

		List<Produto> produtosDoPedido = produtoRepository.findByIdIn(idsProdutos);

		List<PedidoItem> pedidoItens = itens.stream().map(item -> {
			Produto produto = produtosDoPedido.stream().filter(p -> p.getId() == item.getId()).findFirst().get();

			PedidoItem pedidoItem = new PedidoItem();
			pedidoItem.setProduto(produto);
			pedidoItem.setQuantidade(item.getQuantidade());
			return pedidoItem;
		}).collect(Collectors.toList());
		return pedidoItens;
	}

}
