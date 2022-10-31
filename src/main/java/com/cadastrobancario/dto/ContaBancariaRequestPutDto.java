package com.cadastrobancario.dto;

import java.math.BigDecimal;

import javax.persistence.Column;

import com.cadastrobancario.entity.ContaBancaria;
import com.cadastrobancario.entity.Usuario;

public class ContaBancariaRequestPutDto {
	@Column(name = "id")
	private Long id;

	@Column(name = "agencia")
	private long agencia;

	@Column(name = "saldo")
	private BigDecimal saldo;

	@Column(name = "numerodaconta")
	private String numerodaconta;

	public ContaBancaria converterContaBancariaRequestDtoParaEntidadeContaBancaria(Long idUsuario) {
		return new ContaBancaria(null, agencia, saldo, numerodaconta, new Usuario(idUsuario));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getAgencia() {
		return agencia;
	}

	public void setAgencia(long agencia) {
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

}
