package br.com.microservice.project.loja.service;

import br.com.microservice.project.loja.dto.CompraDTO;
import br.com.microservice.project.loja.entity.Compra;

public interface ICompraService {

	Compra realizarCompra(CompraDTO compraDTO);

	Compra save(Compra compra);

	Compra getById(Long id);

}
