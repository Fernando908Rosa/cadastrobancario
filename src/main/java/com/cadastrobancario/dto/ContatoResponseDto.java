package com.cadastrobancario.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.cadastrobancario.entity.Contato;
import com.cadastrobancario.enuns.Tipodecontato;

public class ContatoResponseDto {

	@Column(name = "id")
	private Long id;

	@Column(name = "descricaodotipodecontato")
	private String descricaodotipodecontato;

	@Column(name = "tipodecontato")
	@Enumerated(EnumType.STRING)
	private Tipodecontato tipodecontato;

	public ContatoResponseDto(Long id, String descricaodotipodecontato, Tipodecontato tipodecontato) {
		super();
		this.id = id;
		this.descricaodotipodecontato = descricaodotipodecontato;
		this.tipodecontato = tipodecontato;
	}

	public static ContatoResponseDto converterContatoParaResponseDto(Contato contato) {
		return new ContatoResponseDto(contato.getId(), contato.getDescricaodotipodecontato(),
				contato.getTipodecontato());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricaodotipodecontato() {
		return descricaodotipodecontato;
	}

	public void setDescricaodotipodecontato(String descricaodotipodecontato) {
		this.descricaodotipodecontato = descricaodotipodecontato;
	}

	public Tipodecontato getTipodecontato() {
		return tipodecontato;
	}

	public void setTipodecontato(Tipodecontato tipodecontato) {
		this.tipodecontato = tipodecontato;
	}

}
