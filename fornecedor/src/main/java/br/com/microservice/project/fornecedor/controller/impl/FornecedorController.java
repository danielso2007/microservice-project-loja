package br.com.microservice.project.fornecedor.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservice.project.fornecedor.controller.IFornecedorController;
import br.com.microservice.project.fornecedor.dto.InfoFornecedorDTO;
import br.com.microservice.project.fornecedor.lang.Constants;
import br.com.microservice.project.fornecedor.service.IFornecedorService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Constants.FORNECEDOR)
public class FornecedorController implements IFornecedorController {

	@Autowired
	private IFornecedorService service;

	@Override
	public @ResponseBody ResponseEntity<List<InfoFornecedorDTO>> info(@PathVariable(required = true) String estado) {
		return ResponseEntity.ok(InfoFornecedorDTO.converter(service.getInfoPorEstado(estado)));
	}

}
