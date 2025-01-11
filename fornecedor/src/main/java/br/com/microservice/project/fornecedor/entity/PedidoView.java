package br.com.microservice.project.fornecedor.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity(name = "pedido")
public class PedidoView implements Serializable {

	private static final long serialVersionUID = 6637061346767781134L;
	
	@Id
	private Long id;
	@Column(updatable = false, insertable = false)
	
	private Integer tempoDePreparo;
	
	@Column(updatable = false, insertable = false)
	@Enumerated(EnumType.STRING)
	private PedidoStatus status;

	public PedidoView() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PedidoStatus getStatus() {
		return status;
	}

	public void setStatus(PedidoStatus status) {
		this.status = status;
	}

	public Integer getTempoDePreparo() {
		return tempoDePreparo;
	}

	public void setTempoDePreparo(Integer tempoDePreparo) {
		this.tempoDePreparo = tempoDePreparo;
	}

}
