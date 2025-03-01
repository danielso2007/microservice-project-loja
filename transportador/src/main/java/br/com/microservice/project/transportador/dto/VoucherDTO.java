package br.com.microservice.project.transportador.dto;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
@Validated
public class VoucherDTO implements Serializable {

	private static final long serialVersionUID = 6694923582986736196L;

	@NotNull(message = "O número não pode ser nulo")
	private Long numero;

	@NotNull(message = "A previsão para entrega pode ser nulo")
	private LocalDate previsaoParaEntrega;

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public LocalDate getPrevisaoParaEntrega() {
		return previsaoParaEntrega;
	}

	public void setPrevisaoParaEntrega(LocalDate previsaoParaEntrega) {
		this.previsaoParaEntrega = previsaoParaEntrega;
	}

	@Override
	public String toString() {
		return "VoucherDTO [numero=%s, previsaoParaEntrega=%s]".formatted(numero, previsaoParaEntrega);
	}

}
