package br.com.microservice.project.transportador.dto;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
@Validated
public class EntregaDTO implements Serializable {

	private static final long serialVersionUID = -1605845721942057807L;

	@NotNull(message = "O id do pedido não pode ser nulo")
	@NotEmpty(message = "O id do pedido não pode ser vazia")
	private Long pedidoId;

	@NotNull(message = "A data de entrega não pode ser nulo")
	private LocalDate dataParaEntrega;

	@NotNull(message = "O endereço de origem não pode ser nulo")
	@NotEmpty(message = "O endereço de origem não pode ser vazia")
	private String enderecoOrigem;

	@NotNull(message = "O endereço de destino não pode ser nulo")
	@NotEmpty(message = "O endereço de destino não pode ser vazia")
	private String enderecoDestino;

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public LocalDate getDataParaEntrega() {
		return dataParaEntrega;
	}

	public void setDataParaEntrega(LocalDate dataParaEntrega) {
		this.dataParaEntrega = dataParaEntrega;
	}

	public String getEnderecoDestino() {
		return enderecoDestino;
	}

	public void setEnderecoDestino(String enderecoDestino) {
		this.enderecoDestino = enderecoDestino;
	}

	public String getEnderecoOrigem() {
		return enderecoOrigem;
	}

	public void setEnderecoOrigem(String enderecoOrigem) {
		this.enderecoOrigem = enderecoOrigem;
	}

	@Override
	public String toString() {
		return "EntregaDTO [pedidoId=%s, dataParaEntrega=%s, enderecoOrigem=%s, enderecoDestino=%s]".formatted(
		pedidoId, dataParaEntrega, enderecoOrigem, enderecoDestino);
	}

}
