package com.cadastrobancario.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cadastrobancario.dto.EnderecoRequestDto;

@Entity
@Table(name = "tb_endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String bairro;
	private String nomedarua;
	private String nomedoloteamento;
	private String numerodoprediocomercial;
	private String cep;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;

	public Endereco(Long id, String bairro, String nomedarua, String nomedoloteamento, String numerodoprediocomercial,
			String cep) {
		super();
		this.id = id;
		this.bairro = bairro;
		this.nomedarua = nomedarua;
		this.nomedoloteamento = nomedoloteamento;
		this.numerodoprediocomercial = numerodoprediocomercial;
		this.cep = cep;
	}

	public Endereco() {
	}

	public Endereco(EnderecoRequestDto endereco) {
		this.bairro = endereco.getBairro();
		this.nomedarua = endereco.getNomedarua();
		this.nomedoloteamento = endereco.getNomedoloteamento();
		this.numerodoprediocomercial = endereco.getNumerodoprediocomercial();
		this.cep = endereco.getCep();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNomedarua() {
		return nomedarua;
	}

	public void setNomedarua(String nomedarua) {
		this.nomedarua = nomedarua;
	}

	public String getNomedoloteamento() {
		return nomedoloteamento;
	}

	public void setNomedoloteamento(String nomedoloteamento) {
		this.nomedoloteamento = nomedoloteamento;
	}

	public String getNumerodoprediocomercial() {
		return numerodoprediocomercial;
	}

	public void setNumerodoprediocomercial(String numerodoprediocomercial) {
		this.numerodoprediocomercial = numerodoprediocomercial;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
