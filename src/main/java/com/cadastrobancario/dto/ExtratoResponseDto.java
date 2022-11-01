package com.cadastrobancario.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.cadastrobancario.entity.ContaBancaria;
import com.cadastrobancario.entity.Extrato;
import com.cadastrobancario.enuns.Transacao;

public class ExtratoResponseDto {

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

	@Column(name = "id_contabancaria")
	private ContaBancaria idcontabancaria;

	public ExtratoResponseDto(Long id, BigDecimal valor, String titulo, String descricao, Transacao transacao,
			ContaBancaria idcontabancaria) {
		super();
		this.id = id;
		this.valor = valor;
		this.titulo = titulo;
		this.descricao = descricao;
		this.transacao = transacao;
		this.idcontabancaria = idcontabancaria;
	}

	public static ExtratoResponseDto converterExtratoParaExtratoResponseDto(Extrato extrato) {
		return new ExtratoResponseDto(extrato.getId(), extrato.getValor(), extrato.getTitulo(), extrato.getDescricao(),
				extrato.getTransacao(), extrato.getContabancaria());
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

	public ContaBancaria getIdcontabancaria() {
		return idcontabancaria;
	}

	public void setIdcontabancaria(ContaBancaria idcontabancaria) {
		this.idcontabancaria = idcontabancaria;
	}

}
