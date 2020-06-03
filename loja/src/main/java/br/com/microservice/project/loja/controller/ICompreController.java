package br.com.microservice.project.loja.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.microservice.project.loja.dto.RealizarCompraDTO;
import br.com.microservice.project.loja.entity.Compra;
import br.com.microservice.project.loja.lang.Constants;

public interface ICompreController {

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(produces = { Constants.APPLICATION_JSON_UTF_8, Constants.APPLICATION_XML_UTF_8 })
	@ResponseBody ResponseEntity<Compra> realizaCompra(@RequestBody @Valid RealizarCompraDTO compra);

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path = "/{id}",produces = { Constants.APPLICATION_JSON_UTF_8, Constants.APPLICATION_XML_UTF_8 })
	@ResponseBody ResponseEntity<Compra> getById(@PathVariable(required = true) Long id);

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path = "/reprocessar/{id}", produces = { Constants.APPLICATION_JSON_UTF_8, Constants.APPLICATION_XML_UTF_8 })
	ResponseEntity<Compra> reprocessar(@PathVariable(required = true) Long id);

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path = "/cancelar/{id}", produces = { Constants.APPLICATION_JSON_UTF_8, Constants.APPLICATION_XML_UTF_8 })
	ResponseEntity<Compra> cancelar(@PathVariable(required = true) Long id);

}
