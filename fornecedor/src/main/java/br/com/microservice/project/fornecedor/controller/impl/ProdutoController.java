package br.com.microservice.project.fornecedor.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.microservice.project.fornecedor.controller.IProdutoController;
import br.com.microservice.project.fornecedor.entity.Produto;
import br.com.microservice.project.fornecedor.lang.Constants;
import br.com.microservice.project.fornecedor.service.impl.ProdutoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Constants.PRODUTO)
public class ProdutoController implements IProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@HystrixCommand(fallbackMethod = "getProdutosPorEstadoFallback")
	@Override
	public ResponseEntity<List<Produto>> getProdutosPorEstado(@PathVariable(required = true) String estado) {
		try {
			return ResponseEntity.ok(produtoService.getProdutosPorEstado(estado));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	public ResponseEntity<List<Produto>> getProdutosPorEstadoFallback(@PathVariable(required = true) String estado) {
		// TODO: Apenas estudo.
		return ResponseEntity.ok(new ArrayList<>());
	}
	
}
