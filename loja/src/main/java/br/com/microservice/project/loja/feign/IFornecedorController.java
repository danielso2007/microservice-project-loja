package br.com.microservice.project.loja.feign;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.microservice.project.loja.dto.ItemDaCompraDTO;
import br.com.microservice.project.loja.feign.dto.InfoFornecedorDTO;
import br.com.microservice.project.loja.feign.dto.InfoPedidoDTO;
import br.com.microservice.project.loja.lang.Constants;

@FeignClient("fornecedor")
public interface IFornecedorController {

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path = "api/v1/info/{estado}", produces = { Constants.APPLICATION_JSON_UTF_8, Constants.APPLICATION_XML_UTF_8 })
	@ResponseBody ResponseEntity<List<InfoFornecedorDTO>> info(@PathVariable(required = true) String estado);
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "api/v1/pedido")
	@ResponseBody ResponseEntity<InfoPedidoDTO> realizaPedido(@RequestBody @Valid List<ItemDaCompraDTO> produtos);
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "api/v1/pedido/{id}")
	@ResponseBody ResponseEntity<InfoPedidoDTO> getPedidoPorId(@PathVariable(required = true) Long id);

}
