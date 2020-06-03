package br.com.microservice.project.transportador.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.microservice.project.transportador.dto.EntregaDTO;
import br.com.microservice.project.transportador.dto.VoucherDTO;
import br.com.microservice.project.transportador.lang.Constants;

public interface IEntregaController {

	@ResponseStatus(HttpStatus.OK)
	@PostMapping(produces = { Constants.APPLICATION_JSON_UTF_8, Constants.APPLICATION_XML_UTF_8 })
	@ResponseBody VoucherDTO reservaEntrega(@RequestBody EntregaDTO pedidoDTO);

}
