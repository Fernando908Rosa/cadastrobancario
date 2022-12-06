package com.cadastrobancario.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.cadastrobancario.entity.Socio;
import com.cadastrobancario.enuns.Qualificacao;

public class SocioRequestDto {

	@Column(name = "nome")
	private String nome;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "datadeentrada")
	private Date datadeentrada;

	@Column(name = "qualificacao")
	@Enumerated(EnumType.STRING)
	private Qualificacao qualificacao;

	public Socio converterSocioRequestDtoParaEntidadeSocio() {
		return new Socio(null, nome, cpf, datadeentrada, qualificacao);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDatadeentrada() {
		return datadeentrada;
	}

	public void setDatadeentrada(Date datadeentrada) {
		this.datadeentrada = datadeentrada;
	}

	public Qualificacao getQualificacao() {
		return qualificacao;
	}

	public void setQualificacao(Qualificacao qualificacao) {
		this.qualificacao = qualificacao;
	}

}
