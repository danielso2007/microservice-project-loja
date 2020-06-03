package br.com.microservice.project.loja.service;

import javax.validation.Valid;

import br.com.microservice.project.loja.dto.RealizarCompraDTO;
import br.com.microservice.project.loja.entity.Compra;

public interface ICompraService {

	Compra realizarCompra(RealizarCompraDTO compraDTO);
	Compra save(Compra compra);
	Compra getById(Long id);
	Compra realizaCompraFallback(@Valid RealizarCompraDTO compra);
	Compra cancelar(Long id);
	Compra reprocessar(Long id);

}
