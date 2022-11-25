package com.cadastrobancario.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String bairro;
	private String nomedarua;
	private String nomedoloteamento;
	private Integer numerodoprediocomercial;
	private Integer cep;

	public Endereco() {
	}

	public Endereco(Long id) {
		super();
		this.id = id;
	}

	public Endereco(Long id, String bairro, String nomedarua, String nomedoloteamento, Integer numerodoprediocomercial,
			Integer cep) {
		super();
		this.id = id;
		this.bairro = bairro;
		this.nomedarua = nomedarua;
		this.nomedoloteamento = nomedoloteamento;
		this.numerodoprediocomercial = numerodoprediocomercial;
		this.cep = cep;
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

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", bairro=" + bairro + ", nomedarua=" + nomedarua + ", nomedoloteamento="
				+ nomedoloteamento + ", numerodoprediocomercial=" + numerodoprediocomercial + ", cep=" + cep + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, id, nomedarua, nomedoloteamento, numerodoprediocomercial);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep) && Objects.equals(id, other.id)
				&& Objects.equals(nomedarua, other.nomedarua)
				&& Objects.equals(nomedoloteamento, other.nomedoloteamento)
				&& Objects.equals(numerodoprediocomercial, other.numerodoprediocomercial);
	}

}
