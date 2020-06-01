package br.com.microservice.project.fornecedor.service;

import java.util.List;

import br.com.microservice.project.fornecedor.dto.ItemDoPedidoDTO;
import br.com.microservice.project.fornecedor.entity.Pedido;

public interface IPedidoService {

	Pedido realizaPedido(List<ItemDoPedidoDTO> itens);
	Pedido getPedidoPorId(Long id);

}
