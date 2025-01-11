package br.com.microservice.project.loja.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Compra implements Serializable {

	private static final long serialVersionUID = 43440288712366471L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = true)
	private Long pedidoId;
	@Column(nullable = true)
	private Integer tempoDePreparo;
	@Column(nullable = true)
	private String enderecoDestino;
	@Column(nullable = true)
	private LocalDate dataParaEntrega;
	@Column(nullable = true)
	private Long voucher;
	@NotNull(message = "O status não pode ser nulo")
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private CompraStatus status;

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

	public LocalDate getDataParaEntrega() {
		return dataParaEntrega;
	}

	public void setDataParaEntrega(LocalDate dataParaEntrega) {
		this.dataParaEntrega = dataParaEntrega;
	}

	public Long getVoucher() {
		return voucher;
	}

	public void setVoucher(Long voucher) {
		this.voucher = voucher;
	}

	public CompraStatus getStatus() {
		return status;
	}

	public void setStatus(CompraStatus status) {
		this.status = status;
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
		return "Compra [id=%s, pedidoId=%s, tempoDePreparo=%s, enderecoDestino=%s]".formatted(id, pedidoId,
		tempoDePreparo, enderecoDestino);
	}

}
