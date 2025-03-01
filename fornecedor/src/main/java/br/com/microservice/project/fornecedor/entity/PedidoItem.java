package br.com.microservice.project.fornecedor.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PedidoItem implements Serializable {

	private static final long serialVersionUID = 7544431521285234998L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer quantidade;

	@ManyToOne
	@JoinColumn(name = "produtoId")
	private Produto produto;

	@ManyToOne
	@JoinColumn(name = "pedidoId")
	private PedidoView pedido;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public PedidoView getPedido() {
		return pedido;
	}

	public void setPedido(PedidoView pedido) {
		this.pedido = pedido;
	}

}
