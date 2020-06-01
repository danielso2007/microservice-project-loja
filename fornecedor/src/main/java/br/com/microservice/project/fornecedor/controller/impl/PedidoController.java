package br.com.microservice.project.fornecedor.controller.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservice.project.fornecedor.controller.IPedidoController;
import br.com.microservice.project.fornecedor.dto.ItemDoPedidoDTO;
import br.com.microservice.project.fornecedor.entity.Pedido;
import br.com.microservice.project.fornecedor.lang.Constants;
import br.com.microservice.project.fornecedor.service.impl.PedidoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Constants.PEDIDO)
public class PedidoController implements IPedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	@Override
	public @ResponseBody Pedido realizaPedido(@RequestBody @Valid List<ItemDoPedidoDTO> produtos) {
		return pedidoService.realizaPedido(produtos);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/{id}")
	@Override
	public @ResponseBody Pedido getPedidoPorId(@PathVariable(required = true) Long id) {
		return pedidoService.getPedidoPorId(id);
	}
	
}
