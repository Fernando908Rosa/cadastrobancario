package com.cadastrobancario.dto;

import javax.persistence.Column;

import com.cadastrobancario.entity.Endereco;

public class EnderecoRequestDto {

	@Column(name = "bairro")
	private String bairro;

	@Column(name = "nomedarua")
	private String nomedarua;

	@Column(name = "nomedoloteamento")
	private String nomedoloteamento;

	@Column(name = "numerodoprediocomercial")
	private Integer numerodoprediocomercial;

	@Column(name = "cep")
	private Integer cep;

	public Endereco converterEnderecoRequestDtoParaEntidadeEndereco() {
		return new Endereco(null, bairro, nomedarua, nomedoloteamento, numerodoprediocomercial, cep);
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

	public Integer getNumerodoprediocomercial() {
		return numerodoprediocomercial;
	}

	public void setNumerodoprediocomercial(Integer numerodoprediocomercial) {
		this.numerodoprediocomercial = numerodoprediocomercial;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

}
