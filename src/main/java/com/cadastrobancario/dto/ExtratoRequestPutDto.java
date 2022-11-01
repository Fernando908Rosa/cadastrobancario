package com.cadastrobancario.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.cadastrobancario.entity.ContaBancaria;
import com.cadastrobancario.entity.Extrato;
import com.cadastrobancario.enuns.Transacao;

public class ExtratoRequestPutDto {

	@Column(name = "id")
	private Long id;

	@Column(name = "valor")
	private BigDecimal valor;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "transacao")
	@Enumerated(EnumType.STRING)
	private Transacao transacao;

	public Extrato converterExtratoRequestDtoParaEntidadeExtrato(Long idContaBancaria) {
		return new Extrato(null, valor, titulo, descricao, transacao, new ContaBancaria(idContaBancaria));
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

}
