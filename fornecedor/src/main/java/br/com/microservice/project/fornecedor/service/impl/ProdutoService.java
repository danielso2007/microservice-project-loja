package br.com.microservice.project.fornecedor.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.microservice.project.fornecedor.entity.Produto;
import br.com.microservice.project.fornecedor.repository.ProdutoRepository;
import br.com.microservice.project.fornecedor.service.IProdutoService;

@Transactional(readOnly = true)
@Service
public class ProdutoService implements IProdutoService {

	private static final Logger LOG = LoggerFactory.getLogger(ProdutoService.class);
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	public List<Produto> getProdutosPorEstado(String estado) {
		LOG.info("Obtendo produtos por estado.");
		return produtoRepository.findByEstado(estado);
	}
	
}
