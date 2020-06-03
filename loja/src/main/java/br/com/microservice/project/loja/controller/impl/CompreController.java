package br.com.microservice.project.loja.controller.impl;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservice.project.loja.controller.ICompreController;
import br.com.microservice.project.loja.dto.RealizarCompraDTO;
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

	@Override
	@ResponseBody public ResponseEntity<Compra> getById(@PathVariable(required = true) Long id) {
		try {
			return ResponseEntity.ok(service.getById(id));
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			if (e instanceof EntityNotFoundException) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.badRequest().build();
		}
	}
	
	@Override
	@ResponseBody public ResponseEntity<Compra> realizaCompra(@RequestBody @Valid RealizarCompraDTO compra) {
		LOG.info("Realizando compra...");
		try {
			return ResponseEntity.ok(service.realizarCompra(compra));
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return ResponseEntity.badRequest().build();
		}
	}
	
	@Override
	@ResponseBody public ResponseEntity<Compra> reprocessar(@PathVariable(required = true) Long id) {
		try {
			return ResponseEntity.ok(service.reprocessar(id));
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			if (e instanceof EntityNotFoundException) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.badRequest().build();
		}
	}
	
	@Override
	@ResponseBody public ResponseEntity<Compra> cancelar(@PathVariable(required = true) Long id) {
		try {
			return ResponseEntity.ok(service.cancelar(id));
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			if (e instanceof EntityNotFoundException) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.badRequest().build();
		}
	}

}
