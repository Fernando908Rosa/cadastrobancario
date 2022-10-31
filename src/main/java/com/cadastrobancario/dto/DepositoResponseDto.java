package com.cadastrobancario.dto;

import java.math.BigDecimal;

import javax.persistence.Column;

import com.cadastrobancario.entity.ContaBancaria;

public class DepositoResponseDto {

	@Column(name = "id")
	private Long id;

	@Column(name = "agencia")
	private Long agencia;

	@Column(name = "saldo")
	private BigDecimal saldo;

	@Column(name = "numerodaconta")
	private String numerodaconta;

	public DepositoResponseDto(Long id, Long agencia, BigDecimal saldo, String numerodaconta) {
		super();
		this.id = id;
		this.agencia = agencia;
		this.saldo = saldo;
		this.numerodaconta = numerodaconta;
	}

	public static DepositoResponseDto converterDepositoParaResponseDto(ContaBancaria contabancaria) {
		return new DepositoResponseDto(contabancaria.getId(), contabancaria.getAgencia(), contabancaria.getSaldo(),
				contabancaria.getNumerodaconta());

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

}
