package br.com.microservice.project.loja.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.microservice.project.loja.feign.dto.InfoEntregaDTO;
import br.com.microservice.project.loja.feign.dto.InfoVoucherDTO;
import br.com.microservice.project.loja.lang.Constants;

@FeignClient("transportador")
public interface IEntregaController {

	@ResponseStatus(HttpStatus.OK)
	@PostMapping(path = "api/v1/entregas", produces = { Constants.APPLICATION_JSON_UTF_8, Constants.APPLICATION_XML_UTF_8 })
	@ResponseBody InfoVoucherDTO reservaEntrega(@RequestBody InfoEntregaDTO pedidoDTO);

}
