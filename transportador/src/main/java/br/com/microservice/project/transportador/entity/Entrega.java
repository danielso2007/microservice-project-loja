package br.com.microservice.project.transportador.entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Entrega {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "O id do pedido não pode ser nulo")
	@Column(nullable = false)
	private Long pedidoId;

	@NotNull(message = "A data para busca não pode ser nulo")
	@Column(nullable = false)
	private LocalDate dataParaBusca;

	@NotNull(message = "A previsão de entrega não pode ser nulo")
	@Column(nullable = false)
	private LocalDate previsaoParaEntrega;

	@NotNull(message = "O endereço de origem não pode ser nulo")
	@NotEmpty(message = "O endereço de origem não pode ser vazia")
	@Length(max = 500, message = "O endereço de origem deve ter no máximo 500 caracteres.")
	@Column(nullable = false, length = 500)
	private String enderecoOrigem;

	@NotNull(message = "O endereço de destino não pode ser nulo")
	@NotEmpty(message = "O endereço de destino não pode ser vazia")
	@Length(max = 500, message = "O endereço de destino deve ter no máximo 500 caracteres.")
	@Column(nullable = false, length = 500)
	private String enderecoDestino;

	public LocalDate getDataParaBusca() {
		return dataParaBusca;
	}

	public void setDataParaBusca(LocalDate dataParaBusca) {
		this.dataParaBusca = dataParaBusca;
	}

	public LocalDate getPrevisaoParaEntrega() {
		return previsaoParaEntrega;
	}

	public void setPrevisaoParaEntrega(LocalDate previsaoParaEntrega) {
		this.previsaoParaEntrega = previsaoParaEntrega;
	}

	public String getEnderecoOrigem() {
		return enderecoOrigem;
	}

	public void setEnderecoOrigem(String enderecoOrigem) {
		this.enderecoOrigem = enderecoOrigem;
	}

	public String getEnderecoDestino() {
		return enderecoDestino;
	}

	public void setEnderecoDestino(String enderecoDestino) {
		this.enderecoDestino = enderecoDestino;
	}

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataParaBusca, enderecoDestino, enderecoOrigem, id, pedidoId, previsaoParaEntrega);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Entrega)) {
			return false;
		}
		Entrega other = (Entrega) obj;
		return Objects.equals(dataParaBusca, other.dataParaBusca)
				&& Objects.equals(enderecoDestino, other.enderecoDestino)
				&& Objects.equals(enderecoOrigem, other.enderecoOrigem) && Objects.equals(id, other.id)
				&& Objects.equals(pedidoId, other.pedidoId)
				&& Objects.equals(previsaoParaEntrega, other.previsaoParaEntrega);
	}

	@Override
	public String toString() {
		return 
		"Entrega [id=%s, pedidoId=%s, dataParaBusca=%s, previsaoParaEntrega=%s, enderecoOrigem=%s, enderecoDestino=%s]".formatted(
		id, pedidoId, dataParaBusca, previsaoParaEntrega, enderecoOrigem, enderecoDestino);
	}

}
