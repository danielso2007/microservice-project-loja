package br.com.microservice.project.fornecedor.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.microservice.project.fornecedor.entity.Fornecedor;
import br.com.microservice.project.fornecedor.repository.FornecedorRepository;
import br.com.microservice.project.fornecedor.service.IFornecedorService;

@Transactional(readOnly = true)
@Service
public class FornecedorService implements IFornecedorService {

	private static final Logger LOG = LoggerFactory.getLogger(FornecedorService.class);
	
	@Autowired
	private FornecedorRepository repository;
	
	@Override
	public List<Fornecedor> getInfoPorEstado(String estado) {
		LOG.info("Obtendo fornecedores por estado: " + estado);
		return repository.findByEstadoIgnoreCase(estado);
	}

}
