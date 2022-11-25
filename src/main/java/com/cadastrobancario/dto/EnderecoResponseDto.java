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
	private Integer numerodoprediocomercial;

	@Column(name = "cep")
	private Integer cep;

	public EnderecoResponseDto(Long id, String bairro, String nomedarua, String nomedoloteamento,
			Integer numerodoprediocomercial, Integer cep) {
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
