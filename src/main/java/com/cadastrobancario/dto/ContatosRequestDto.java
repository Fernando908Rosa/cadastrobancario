package com.cadastrobancario.dto;

import java.math.BigDecimal;

import javax.persistence.Column;

import com.cadastrobancario.entity.Contatos;

public class ContatosRequestDto {

	@Column(name = "telefone")
	private BigDecimal telefone;

	@Column(name = "email")
	private String email;

	public Contatos converterContatosRequestDtoParaEntidadeContatos() {
		return new Contatos(null, telefone, email);

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

}
