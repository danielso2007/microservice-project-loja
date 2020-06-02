package br.com.microservice.project.loja.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.microservice.project.loja.entity.Compra;

@Repository
public interface CompraRepository extends CrudRepository<Compra, Long> {

}
