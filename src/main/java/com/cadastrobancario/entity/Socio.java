package com.cadastrobancario.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cadastrobancario.dto.SocioRequestDto;
import com.cadastrobancario.enuns.Qualificacao;

@Entity
@Table(name = "tb_socio")
public class Socio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cpf;
	private Date datadeentrada;
	private Qualificacao qualificacao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "socio")
	private Empresa empresa;

	public Socio(String nome, String cpf, Date datadeentrada, Qualificacao qualificacao) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.datadeentrada = datadeentrada;
		this.qualificacao = qualificacao;
	}

	public Socio() {
	}

	public Socio(List<SocioRequestDto> socio, String nome, String cpf, Date datadeentrada, Qualificacao qualificacao) {
		this.nome = nome;
		this.cpf = cpf;
		this.datadeentrada = datadeentrada;
		this.qualificacao = qualificacao;
	}

	public Socio(SocioRequestDto sociodto) {
		this.nome = sociodto.getNome();
		this.cpf = sociodto.getCpf();
		this.datadeentrada = sociodto.getDatadeentrada();
		this.qualificacao = sociodto.getQualificacao();

	}

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