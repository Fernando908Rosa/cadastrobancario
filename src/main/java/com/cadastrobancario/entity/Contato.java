package com.cadastrobancario.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cadastrobancario.dto.ContatoRequestDto;
import com.cadastrobancario.enuns.Tipodecontato;

@Entity
@Table(name = "tb_contato")
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String descricaodotipodecontato;
	private Tipodecontato tipodecontato;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contato")
	private Empresa empresa;

	public Contato(Long id, String descricaodotipodecontato, Tipodecontato tipodecontato) {
		super();
		this.id = id;
		this.descricaodotipodecontato = descricaodotipodecontato;
		this.tipodecontato = tipodecontato;
	}

	public Contato() {
	}

	public Contato(ContatoRequestDto contato) {
		this.descricaodotipodecontato = contato.getDescricaodotipodecontato();
		this.tipodecontato = contato.getTipodecontato();
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
