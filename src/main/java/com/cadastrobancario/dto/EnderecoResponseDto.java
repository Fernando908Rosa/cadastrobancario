package com.cadastrobancario.dto;

import javax.persistence.Column;

import com.cadastrobancario.entity.Endereco;

public class EnderecoResponseDto {

	@Column(name = "id")
	private Long id;

	@Column(name = "bairro")
	private String bairro;

	@Column(name = "nomedarua")
	private String nomedarua;

	@Column(name = "nomedoloteamento")
	private String nomedoloteamento;

	@Column(name = "numerodoprediocomercial")
	private String numerodoprediocomercial;

	@Column(name = "cep")
	private String cep;

	public EnderecoResponseDto(Long id, String bairro, String nomedarua, String nomedoloteamento,
			String numerodoprediocomercial, String cep) {
		super();
		this.id = id;
		this.bairro = bairro;
		this.nomedarua = nomedarua;
		this.nomedoloteamento = nomedoloteamento;
		this.numerodoprediocomercial = numerodoprediocomercial;
		this.cep = cep;
	}

	public static EnderecoResponseDto converterEnderecoParaResponseDto(Endereco endereco) {
		return new EnderecoResponseDto(endereco.getId(), endereco.getBairro(), endereco.getNomedarua(),
				endereco.getNomedoloteamento(), endereco.getNumerodoprediocomercial(), endereco.getCep());
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

}
