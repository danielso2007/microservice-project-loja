package br.com.microservice.project.loja.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
@Validated
public class CompraDTO implements Serializable {

	private static final long serialVersionUID = -718293074332512886L;

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

	@Override
	public String toString() {
		return String.format("CompraDTO [itens=%s, endereco=%s]", itens, endereco);
	}

}
