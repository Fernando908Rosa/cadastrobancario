package com.cadastrobancario.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_empresa")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String cnpj;
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

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "empresa")
	private Endereco endereco;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_empresa", referencedColumnName = "id")
	private List<Contato> contato;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_empresa", referencedColumnName = "id")
	private List<Socio> socio;

	public Empresa() {
	}

	public Empresa(Long id, String cnpj, String nomedaempresa, String fantasianome, Date iniciodaatividade,
			String naturezajuridica, Date situacaocadastral, String qualificacaodoresponsavel, BigDecimal capitalsocial,
			String portedaempresa, Date opcaopelosimplesexcluidodosimples, String opcaopelomei, Endereco endereco,
			List<Contato> contato, List<Socio> socio) {
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
		this.endereco = endereco;
		this.contato = contato;
		this.socio = socio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Contato> getContato() {
		return contato;
	}

	public void setContato(List<Contato> contato) {
		this.contato = contato;
	}

	public List<Socio> getSocio() {
		return socio;
	}

	public void setSocio(List<Socio> socio) {
		this.socio = socio;
	}

}
