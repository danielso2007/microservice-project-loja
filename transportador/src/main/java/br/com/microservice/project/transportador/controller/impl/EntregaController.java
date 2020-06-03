package br.com.microservice.project.transportador.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.microservice.project.transportador.controller.IEntregaController;
import br.com.microservice.project.transportador.dto.EntregaDTO;
import br.com.microservice.project.transportador.dto.VoucherDTO;
import br.com.microservice.project.transportador.lang.Constants;
import br.com.microservice.project.transportador.service.EntregaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Constants.ENTREGAS)
public class EntregaController implements IEntregaController {
	
	@Autowired
	private EntregaService entregaService;

	@HystrixCommand(threadPoolKey = "reservaEntregaThreadPool")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(produces = { Constants.APPLICATION_JSON_UTF_8, Constants.APPLICATION_XML_UTF_8 })
	@Override
	public @ResponseBody VoucherDTO reservaEntrega(@RequestBody EntregaDTO pedidoDTO) {
		return entregaService.reservaEntrega(pedidoDTO);
	}
}
