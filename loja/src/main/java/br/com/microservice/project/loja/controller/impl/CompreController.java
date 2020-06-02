package br.com.microservice.project.loja.controller.impl;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.microservice.project.loja.controller.ICompreController;
import br.com.microservice.project.loja.dto.CompraDTO;
import br.com.microservice.project.loja.entity.Compra;
import br.com.microservice.project.loja.lang.Constants;
import br.com.microservice.project.loja.service.ICompraService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Constants.COMPRAS)
public class CompreController implements ICompreController {

	private static final Logger LOG = LoggerFactory.getLogger(CompreController.class);
	
	@Autowired
	private ICompraService service;

	@HystrixCommand(fallbackMethod = "realizaCompraFallback")
	@Override
	public ResponseEntity<Compra> realizaCompra(@RequestBody @Valid CompraDTO compra) {
		LOG.info("Realizando compra...");
		try {
			return ResponseEntity.ok(service.realizarCompra(compra));
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return ResponseEntity.badRequest().build();
		}
	}
	
	public ResponseEntity<Compra> realizaCompraFallback(@RequestBody @Valid CompraDTO compra) {
		LOG.info("Realizando compra (Fallback) ...");
		return ResponseEntity.ok(new Compra());
	}

}
