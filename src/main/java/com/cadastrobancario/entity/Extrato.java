package com.cadastrobancario.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cadastrobancario.enuns.Transacao;

@Entity
@Table(name = "tb_extrato")
public class Extrato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal valor;
	private String titulo;
	private String descricao;
	private Transacao transacao;

	@ManyToOne
	@JoinColumn(name = "contabancaria_id", referencedColumnName = "id")
	private ContaBancaria contabancaria;

	public Extrato(Long id, BigDecimal valor, String titulo, String descricao, Transacao transacao,
			ContaBancaria contabancaria) {
		super();
		this.id = id;
		this.valor = valor;
		this.titulo = titulo;
		this.descricao = descricao;
		this.transacao = transacao;
		this.contabancaria = contabancaria;
	}

	public Extrato(BigDecimal valor, String titulo, String descricao, Transacao transacao,
			ContaBancaria contabancaria) {
		super();
		this.valor = valor;
		this.titulo = titulo;
		this.descricao = descricao;
		this.transacao = transacao;
		this.contabancaria = contabancaria;
	}

	public Extrato() {
		super();
	}

	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
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

	public Transacao getTransacao() {
		return transacao;
	}

	public void setTransacao(Transacao transacao) {
		this.transacao = transacao;
	}

	public ContaBancaria getContabancaria() {
		return contabancaria;
	}

	public void setContabancaria(ContaBancaria contabancaria) {
		this.contabancaria = contabancaria;
	}

}
