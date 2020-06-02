package br.com.microservice.project.fornecedor.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.microservice.project.fornecedor.entity.Produto;
import br.com.microservice.project.fornecedor.lang.Constants;

public interface IProdutoController {

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path = "/{estado}", produces = { Constants.APPLICATION_JSON_UTF_8, Constants.APPLICATION_XML_UTF_8 })
	@ResponseBody ResponseEntity<List<Produto>> getProdutosPorEstado(@PathVariable(required = true) String estado);

}
