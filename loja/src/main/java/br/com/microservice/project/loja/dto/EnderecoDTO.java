package br.com.microservice.project.loja.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
@Validated
public class EnderecoDTO implements Serializable {

	private static final long serialVersionUID = -3251219243145887121L;

	@NotNull(message = "A rua não pode ser nulo")
	@NotEmpty(message = "A rua não pode ser vazia")
	private String rua;
	private int numero;
	@NotNull(message = "O estado não pode ser nulo")
	@NotEmpty(message = "O estado não pode ser vazia")
	private String estado;

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(estado, numero, rua);
	}

	public String enderecoCompleto() {
		return String.format("%s, %s, %s", getRua(), getNumero(), getEstado());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof EnderecoDTO)) {
			return false;
		}
		EnderecoDTO other = (EnderecoDTO) obj;
		return Objects.equals(estado, other.estado) && numero == other.numero && Objects.equals(rua, other.rua);
	}

	@Override
	public String toString() {
		return String.format("EnderecoDTO [rua=%s, numero=%s, estado=%s]", rua, numero, estado);
	}

}
