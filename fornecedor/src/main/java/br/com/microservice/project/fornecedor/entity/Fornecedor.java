package br.com.microservice.project.fornecedor.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Fornecedor implements Serializable {

	private static final long serialVersionUID = 1781951435913366240L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "O nome não pode ser nulo")
	@NotEmpty(message = "O nome não pode ser vazio")
	@Length(min = 3, max = 255, message = "O nome deve ter no mínimo 3 e no máximo 255 caracteres")
	@Column(nullable = false, length = 255)
	private String nome;

	@NotNull(message = "O estado não pode ser nulo")
	@NotEmpty(message = "O estado não pode ser vazio")
	@Length(min = 2, max = 2, message = "O estado deve ter 2 caracteres")
	@Column(nullable = false, length = 2)
	private String estado;

	@NotNull(message = "O endereço não pode ser nulo")
	@NotEmpty(message = "O endereço não pode ser vazio")
	@Length(min = 5, max = 500, message = "O endereço deve ter no mínimo 5 e no máximo 500 caracteres")
	@Column(nullable = false, length = 500)
	private String endereco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Fornecedor)) {
			return false;
		}
		Fornecedor other = (Fornecedor) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return String.format("Fornecedor [id=%s, nome=%s, estado=%s, endereco=%s]", id, nome, estado, endereco);
	}

}
