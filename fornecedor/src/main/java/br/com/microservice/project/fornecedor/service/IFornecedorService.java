package br.com.microservice.project.fornecedor.service;

import java.util.List;

import br.com.microservice.project.fornecedor.entity.Fornecedor;

public interface IFornecedorService {

	List<Fornecedor> getInfoPorEstado(String estado);

}
