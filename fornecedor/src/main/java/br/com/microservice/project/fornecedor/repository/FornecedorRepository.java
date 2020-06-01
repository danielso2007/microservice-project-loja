package br.com.microservice.project.fornecedor.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.microservice.project.fornecedor.entity.Fornecedor;

@Repository
public interface FornecedorRepository extends CrudRepository<Fornecedor, Long> {

	List<Fornecedor> findByEstadoIgnoreCase(String estado);
	
}
