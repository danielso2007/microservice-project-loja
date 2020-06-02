package br.com.microservice.project.transportador.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.microservice.project.transportador.entity.Entrega;

@Repository
public interface EntregaRepository extends CrudRepository<Entrega, Long>{

}
