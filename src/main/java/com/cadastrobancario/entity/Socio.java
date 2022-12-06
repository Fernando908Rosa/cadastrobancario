package com.cadastrobancario.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "empresa_id")
	private List<Socio> socio;


	public Socio() {
	}

	public Socio(Long id, String nome, String cpf, Date datadeentrada, Qualificacao qualificacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.datadeentrada = datadeentrada;
		this.qualificacao = qualificacao;
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
