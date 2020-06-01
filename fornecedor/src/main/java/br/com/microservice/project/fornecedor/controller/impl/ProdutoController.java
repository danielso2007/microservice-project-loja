package br.com.microservice.project.fornecedor.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@Override
	public List<Produto> getProdutosPorEstado(@PathVariable(required = true) String estado) {
		return produtoService.getProdutosPorEstado(estado);
	}
	
}
