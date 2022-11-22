package com.cadastrobancario.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.cadastrobancario.entity.ContaBancaria;
import com.cadastrobancario.enuns.Transacao;

public class TransacaoGenericoRequestDto {

	@Column(name = "id")
	private Long id;

	@Column(name = "agencia")
	private Long agencia;

	@Column(name = "saldo")
	private BigDecimal saldo;

	@Column(name = "numerodaconta")
	private String numerodaconta;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "email")
	private String email;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "transacaogenerico")
	@Enumerated(EnumType.STRING)
	private Transacao transacaogenerico;

	public ContaBancaria converterContaBancariaParaEntidadeContaBancaria() {
		return new ContaBancaria(id, agencia, saldo, numerodaconta, email, telefone, transacaogenerico);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAgencia() {
		return agencia;
	}

	public void setAgencia(Long agencia) {
		this.agencia = agencia;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getNumerodaconta() {
		return numerodaconta;
	}

	public void setNumerodaconta(String numerodaconta) {
		this.numerodaconta = numerodaconta;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Transacao getTransacaogenerico() {
		return transacaogenerico;
	}

	public void setTransacaogenerico(Transacao transacaogenerico) {
		this.transacaogenerico = transacaogenerico;
	}

	
}
