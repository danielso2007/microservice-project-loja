package br.com.microservice.project.fornecedor.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.microservice.project.fornecedor.entity.PedidoItem;

@Repository
public interface PedidoItemRepository extends CrudRepository<PedidoItem, Long> {

}
