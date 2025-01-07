package br.com.microservice.project.fornecedor.dto;

public class ItemDoPedidoDTO {

	private long id;

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
	public String toString() {
		return String.format("ItemDoPedidoDTO [id=%d, quantidade=%d]", id, quantidade);
	}

}
