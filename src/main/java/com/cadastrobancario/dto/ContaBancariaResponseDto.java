package com.cadastrobancario.dto;

import java.math.BigDecimal;

import javax.persistence.Column;

import com.cadastrobancario.entity.ContaBancaria;
import com.cadastrobancario.entity.Usuario;

public class ContaBancariaResponseDto {

	@Column(name = "id")
	private Long id;

	@Column(name = "agencia")
	private Long agencia;

	@Column(name = "saldo")
	private BigDecimal saldo;

	@Column(name = "numerodaconta")
	private String numerodaconta;

	@Column(name = "id_usuario")
	private Usuario idusuario;

	public ContaBancariaResponseDto(Long id, Long agencia, BigDecimal saldo, String numerodaconta, Usuario idusuario) {
		super();
		this.id = id;
		this.agencia = agencia;
		this.saldo = saldo;
		this.numerodaconta = numerodaconta;
		this.idusuario = idusuario;
	}

	public static ContaBancariaResponseDto converterContaBancariaParaResponseDto(ContaBancaria contabancaria) {
		return new ContaBancariaResponseDto(contabancaria.getId(), contabancaria.getAgencia(), contabancaria.getSaldo(),
				contabancaria.getNumerodaconta(), contabancaria.getUsuario());

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

	public Usuario getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Usuario idusuario) {
		this.idusuario = idusuario;
	}

}
