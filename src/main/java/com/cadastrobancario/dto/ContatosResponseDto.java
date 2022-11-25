package com.cadastrobancario.dto;

import java.math.BigDecimal;

import javax.persistence.Column;

import com.cadastrobancario.entity.Contatos;

public class ContatosResponseDto {

	@Column(name = "id")
	private Long id;

	@Column(name = "telefone")
	private BigDecimal telefone;

	@Column(name = "email")
	private String email;

	public ContatosResponseDto(Long id, String email, BigDecimal telefone) {
		super();
		this.id = id;
		this.telefone = telefone;
		this.email = email;
	}

	public static ContatosResponseDto converterContatosParaResponseDto(Contatos contatos) {
		return new ContatosResponseDto(contatos.getId(), contatos.getEmail(), contatos.getTelefone());
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

}
