package com.cadastrobancario.entity;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_contatos")
public class Contatos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private BigDecimal telefone;
	private String email;

	public Contatos() {
	}

	public Contatos(Long id) {
		super();
		this.id = id;
	}

	public Contatos(Long id, BigDecimal telefone, String email) {
		super();
		this.id = id;
		this.telefone = telefone;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getTelefone() {
		return telefone;
	}

	public void setTelefone(BigDecimal telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contatos [id=" + id + ", telefone=" + telefone + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contatos other = (Contatos) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(telefone, other.telefone);
	}

}
