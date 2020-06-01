package br.com.microservice.project.loja.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.microservice.project.loja.dto.CompraDTO;
import br.com.microservice.project.loja.entity.Compra;
import br.com.microservice.project.loja.lang.Constants;

public interface ICompreController {

	@PostMapping(produces = { Constants.APPLICATION_JSON_UTF_8, Constants.APPLICATION_XML_UTF_8 })
	Compra realizaCompra(@RequestBody @Valid CompraDTO compra);

}
