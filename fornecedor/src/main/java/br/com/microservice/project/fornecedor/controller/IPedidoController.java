package br.com.microservice.project.fornecedor.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.microservice.project.fornecedor.dto.ItemDoPedidoDTO;
import br.com.microservice.project.fornecedor.entity.Pedido;

public interface IPedidoController {

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	@ResponseBody ResponseEntity<Pedido> realizaPedido(@RequestBody @Valid List<ItemDoPedidoDTO> produtos);
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/{id}")
	@ResponseBody ResponseEntity<Pedido> getPedidoPorId(@PathVariable(required = true) Long id);

}
