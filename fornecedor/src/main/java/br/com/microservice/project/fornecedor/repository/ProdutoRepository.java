package br.com.microservice.project.fornecedor.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.microservice.project.fornecedor.entity.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

	List<Produto> findByEstado(String estado);
	List<Produto> findByIdIn(List<Long> idsProdutos);

}
