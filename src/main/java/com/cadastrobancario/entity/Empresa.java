package com.cadastrobancario.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_empresa")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private BigDecimal cnpj;
	private String nomedaempresa;
	private String fantasianome;
	private Date iniciodaatividade;
	private String naturezajuridica;
	private Date situacaocadastral;
	private String qualificacaodoresponsavel;
	private BigDecimal capitalsocial;
	private String portedaempresa;
	private Date opcaopelosimplesexcluidodosimples;
	private String opcaopelomei;

	public Empresa() {
	}

	public Empresa(Long id) {
		super();
		this.id = id;
	}

	public Empresa(Long id, BigDecimal cnpj, String nomedaempresa, String fantasianome, Date iniciodaatividade,
			String naturezajuridica, Date situacaocadastral, String qualificacaodoresponsavel, BigDecimal capitalsocial,
			String portedaempresa, Date opcaopelosimplesexcluidodosimples, String opcaopelomei) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.nomedaempresa = nomedaempresa;
		this.fantasianome = fantasianome;
		this.iniciodaatividade = iniciodaatividade;
		this.naturezajuridica = naturezajuridica;
		this.situacaocadastral = situacaocadastral;
		this.qualificacaodoresponsavel = qualificacaodoresponsavel;
		this.capitalsocial = capitalsocial;
		this.portedaempresa = portedaempresa;
		this.opcaopelosimplesexcluidodosimples = opcaopelosimplesexcluidodosimples;
		this.opcaopelomei = opcaopelomei;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getCnpj() {
		return cnpj;
	}

	public void setCnpj(BigDecimal cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomedaempresa() {
		return nomedaempresa;
	}

	public void setNomedaempresa(String nomedaempresa) {
		this.nomedaempresa = nomedaempresa;
	}

	public String getFantasianome() {
		return fantasianome;
	}

	public void setFantasianome(String fantasianome) {
		this.fantasianome = fantasianome;
	}

	public Date getIniciodaatividade() {
		return iniciodaatividade;
	}

	public void setIniciodaatividade(Date iniciodaatividade) {
		this.iniciodaatividade = iniciodaatividade;
	}

	public String getNaturezajuridica() {
		return naturezajuridica;
	}

	public void setNaturezajuridica(String naturezajuridica) {
		this.naturezajuridica = naturezajuridica;
	}

	public Date getSituacaocadastral() {
		return situacaocadastral;
	}

	public void setSituacaocadastral(Date situacaocadastral) {
		this.situacaocadastral = situacaocadastral;
	}

	public String getQualificacaodoresponsavel() {
		return qualificacaodoresponsavel;
	}

	public void setQualificacaodoresponsavel(String qualificacaodoresponsavel) {
		this.qualificacaodoresponsavel = qualificacaodoresponsavel;
	}

	public BigDecimal getCapitalsocial() {
		return capitalsocial;
	}

	public void setCapitalsocial(BigDecimal capitalsocial) {
		this.capitalsocial = capitalsocial;
	}

	public String getPortedaempresa() {
		return portedaempresa;
	}

	public void setPortedaempresa(String portedaempresa) {
		this.portedaempresa = portedaempresa;
	}

	public Date getOpcaopelosimplesexcluidodosimples() {
		return opcaopelosimplesexcluidodosimples;
	}

	public void setOpcaopelosimplesexcluidodosimples(Date opcaopelosimplesexcluidodosimples) {
		this.opcaopelosimplesexcluidodosimples = opcaopelosimplesexcluidodosimples;
	}

	public String getOpcaopelomei() {
		return opcaopelomei;
	}

	public void setOpcaopelomei(String opcaopelomei) {
		this.opcaopelomei = opcaopelomei;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", cnpj=" + cnpj + ", nomedaempresa=" + nomedaempresa + ", fantasianome="
				+ fantasianome + ", iniciodaatividade=" + iniciodaatividade + ", naturezajuridica=" + naturezajuridica
				+ ", situacaocadastral=" + situacaocadastral + ", qualificacaodoresponsavel="
				+ qualificacaodoresponsavel + ", capitalsocial=" + capitalsocial + ", portedaempresa=" + portedaempresa
				+ ", opcaopelosimplesexcluidodosimples=" + opcaopelosimplesexcluidodosimples + ", opcaopelomei="
				+ opcaopelomei + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(capitalsocial, cnpj, fantasianome, id, iniciodaatividade, naturezajuridica, nomedaempresa,
				opcaopelomei, opcaopelosimplesexcluidodosimples, portedaempresa, qualificacaodoresponsavel,
				situacaocadastral);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(capitalsocial, other.capitalsocial) && Objects.equals(cnpj, other.cnpj)
				&& Objects.equals(fantasianome, other.fantasianome) && Objects.equals(id, other.id)
				&& Objects.equals(iniciodaatividade, other.iniciodaatividade)
				&& Objects.equals(naturezajuridica, other.naturezajuridica)
				&& Objects.equals(nomedaempresa, other.nomedaempresa)
				&& Objects.equals(opcaopelomei, other.opcaopelomei)
				&& Objects.equals(opcaopelosimplesexcluidodosimples, other.opcaopelosimplesexcluidodosimples)
				&& Objects.equals(portedaempresa, other.portedaempresa)
				&& Objects.equals(qualificacaodoresponsavel, other.qualificacaodoresponsavel)
				&& Objects.equals(situacaocadastral, other.situacaocadastral);
	}

}
