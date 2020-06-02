package br.com.microservice.project.loja.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Compra implements Serializable {

	private static final long serialVersionUID = 43440288712366471L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "O número do pedido não pode ser nulo")
	@Column(nullable = false)
	private Long pedidoId;
	@NotNull(message = "O tempo de preparo não pode ser nulo")
	@Min(value = 1, message = "O tempo de preparo é no mínimo 1")
	@Column(nullable = false)
	private Integer tempoDePreparo;
	@NotNull(message = "O endereço de destino não pode ser nulo")
	@NotEmpty(message = "O endereço de destino não pode ser vazio")
	@Length(min = 10, max = 500, message = "O endereço de destino deve ter no mínimo 10 e no máximo 500 caracteres")
	@Column(nullable = false, length = 500)
	private String enderecoDestino;

	public Compra() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public Integer getTempoDePreparo() {
		return tempoDePreparo;
	}

	public void setTempoDePreparo(Integer tempoDePreparo) {
		this.tempoDePreparo = tempoDePreparo;
	}

	public String getEnderecoDestino() {
		return enderecoDestino;
	}

	public void setEnderecoDestino(String enderecoDestino) {
		this.enderecoDestino = enderecoDestino;
	}

	@Override
	public int hashCode() {
		return Objects.hash(enderecoDestino, id, pedidoId, tempoDePreparo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Compra)) {
			return false;
		}
		Compra other = (Compra) obj;
		return Objects.equals(enderecoDestino, other.enderecoDestino) && Objects.equals(id, other.id)
				&& Objects.equals(pedidoId, other.pedidoId) && Objects.equals(tempoDePreparo, other.tempoDePreparo);
	}

	@Override
	public String toString() {
		return String.format("Compra [id=%s, pedidoId=%s, tempoDePreparo=%s, enderecoDestino=%s]", id, pedidoId,
				tempoDePreparo, enderecoDestino);
	}

}
