package br.com.microservice.project.loja.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
@Validated
public class ItemDaCompraDTO implements Serializable {

	private static final long serialVersionUID = 5112664179162915232L;

	private long id;
	@Min(value = 1, message = "O mínimo de itens é de 1 (uma) unidade")
	private int quantidade;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, quantidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ItemDaCompraDTO)) {
			return false;
		}
		ItemDaCompraDTO other = (ItemDaCompraDTO) obj;
		return id == other.id && quantidade == other.quantidade;
	}

	@Override
	public String toString() {
		return String.format("ItemDaCompraDTO [id=%d, quantidade=%d]", id, quantidade);
	}

}
