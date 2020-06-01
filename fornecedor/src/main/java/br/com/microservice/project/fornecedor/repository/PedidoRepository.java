package br.com.microservice.project.fornecedor.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.microservice.project.fornecedor.entity.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {

}
