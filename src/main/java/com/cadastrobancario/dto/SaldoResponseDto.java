package com.cadastrobancario.dto;

import java.math.BigDecimal;

import javax.persistence.Column;

import com.cadastrobancario.entity.ContaBancaria;

public class SaldoResponseDto {

	@Column(name = "saldo")
	private BigDecimal saldo;

	public SaldoResponseDto() {
		super();
	}

	public SaldoResponseDto(BigDecimal saldo) {
		super();
		this.saldo = saldo;
	}

	public static SaldoResponseDto converterSaldoParaResponseDto(ContaBancaria contabancaria) {
		return new SaldoResponseDto(contabancaria.getSaldo());
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

}
