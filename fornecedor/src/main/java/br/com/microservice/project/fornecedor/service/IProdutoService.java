package br.com.microservice.project.fornecedor.service;

import java.util.List;

import br.com.microservice.project.fornecedor.entity.Produto;

public interface IProdutoService {

	List<Produto> getProdutosPorEstado(String estado);

}
