package br.com.microservice.project.fornecedor.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

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

	@HystrixCommand(fallbackMethod = "infoFallback", threadPoolKey = "infoThreadPool")
	@Override
	public @ResponseBody ResponseEntity<List<InfoFornecedorDTO>> info(@PathVariable(required = true) String estado) {
		try {
			return ResponseEntity.ok(InfoFornecedorDTO.converter(service.getInfoPorEstado(estado)));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	public @ResponseBody ResponseEntity<List<InfoFornecedorDTO>> infoFallback(@PathVariable(required = true) String estado) {
		// TODO: Apenas estudo.
		return ResponseEntity.ok().build();
	}

}
