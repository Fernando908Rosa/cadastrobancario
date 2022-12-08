package com.cadastrobancario.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.cadastrobancario.entity.Contato;
import com.cadastrobancario.enuns.Tipodecontato;

public class ContatoRequestDto {

	@Column(name = "descricaodotipodecontato")
	private String descricaodotipodecontato;

	@Column(name = "Tipodecontato")
	@Enumerated(EnumType.STRING)
	private Tipodecontato tipodecontato;

	public Contato converterContatoRequestDtoParaEntidadeContato() {
		return new Contato( null, descricaodotipodecontato, tipodecontato);

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
