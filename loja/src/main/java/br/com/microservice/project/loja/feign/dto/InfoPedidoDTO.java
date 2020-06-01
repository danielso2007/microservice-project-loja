package br.com.microservice.project.loja.feign.dto;

import java.io.Serializable;

public class InfoPedidoDTO implements Serializable {

	private static final long serialVersionUID = 8611108846346138184L;

	private Long id;

	private Integer tempoDePreparo;

	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTempoDePreparo() {
		return tempoDePreparo;
	}

	public void setTempoDePreparo(Integer tempoDePreparo) {
		this.tempoDePreparo = tempoDePreparo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
