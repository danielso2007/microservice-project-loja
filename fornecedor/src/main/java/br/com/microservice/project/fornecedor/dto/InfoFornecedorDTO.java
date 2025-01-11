package br.com.microservice.project.fornecedor.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.microservice.project.fornecedor.entity.Fornecedor;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
@Validated
public class InfoFornecedorDTO implements Serializable {

	private static final long serialVersionUID = 4699781042600709725L;

	private String endereco;

	public InfoFornecedorDTO() {
		super();
	}

	public InfoFornecedorDTO(Fornecedor entity) {
		this.endereco = entity.getEndereco();
	}

	public InfoFornecedorDTO(String endereco) {
		this.endereco = endereco;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public static List<InfoFornecedorDTO> converter(List<Fornecedor> list) {
		return list.stream().map(InfoFornecedorDTO::new).collect(Collectors.toList());
	}

	@Override
	public int hashCode() {
		return Objects.hash(endereco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof InfoFornecedorDTO)) {
			return false;
		}
		InfoFornecedorDTO other = (InfoFornecedorDTO) obj;
		return Objects.equals(endereco, other.endereco);
	}

	@Override
	public String toString() {
		return "InfoFornecedorDTO [endereco=%s]".formatted(endereco);
	}

}
