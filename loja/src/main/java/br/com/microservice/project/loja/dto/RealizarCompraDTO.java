package br.com.microservice.project.loja.dto;

import java.io.Serializable;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
@Validated
public class RealizarCompraDTO implements Serializable {

	private static final long serialVersionUID = -718293074332512886L;

	@JsonIgnore
	private Long compraId;
	
	@NotNull(message = "A lista de itens não pode ser nulo")
	@NotEmpty(message = "A lista de itens não pode ser vazia")
	private List<ItemDaCompraDTO> itens;

	@NotNull(message = "O endereço não pode ser nulo")
	private EnderecoDTO endereco;

	public List<ItemDaCompraDTO> getItens() {
		return itens;
	}

	public void setItens(List<ItemDaCompraDTO> itens) {
		this.itens = itens;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}
	
	public Long getCompraId() {
		return compraId;
	}

	public void setCompraId(Long compraId) {
		this.compraId = compraId;
	}

	@Override
	public String toString() {
		return "RealizarCompraDTO [itens=%s, endereco=%s]".formatted(itens, endereco);
	}

}
