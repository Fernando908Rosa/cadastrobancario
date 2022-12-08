package com.cadastrobancario.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import com.cadastrobancario.entity.Contato;
import com.cadastrobancario.entity.Empresa;
import com.cadastrobancario.entity.Endereco;
import com.cadastrobancario.entity.Socio;

public class EmpresaResponseDto {

	@Column(name = "id")
	private Long id;

	@Column(name = "cnpj")
	private String cnpj;

	@Column(name = "nomedaempresa")
	private String nomedaempresa;

	@Column(name = "fantasianome")
	private String fantasianome;

	@Column(name = "iniciodaatividade")
	private Date iniciodaatividade;

	@Column(name = "naturezajuridica")
	private String naturezajuridica;

	@Column(name = "situacaocadastral")
	private Date situacaocadastral;

	@Column(name = "qualificacaodoresponsavel")
	private String qualificacaodoresponsavel;

	@Column(name = "capitalsocial")
	private BigDecimal capitalsocial;

	@Column(name = "portedaempresa")
	private String portedaempresa;

	@Column(name = "opcaopelosimplesexcluidodosimples")
	private Date opcaopelosimplesexcluidodosimples;

	@Column(name = "opcaopelomei")
	private String opcaopelomei;

	@Column(name = "endereco")
	private Endereco endereco;

	@Column(name = "contato")
	private List<Contato> contato;

	@Column(name = "socio")
	private List<Socio> socio;

	public EmpresaResponseDto(Long id, String cnpj, String nomedaempresa, String fantasianome, Date iniciodaatividade,
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

	public static EmpresaResponseDto converterEmpresaParaEmpresaResponseDto(Empresa empresa) {
		return new EmpresaResponseDto(empresa.getId(), empresa.getCnpj(), empresa.getNomedaempresa(),
				empresa.getFantasianome(), empresa.getIniciodaatividade(), empresa.getNaturezajuridica(),
				empresa.getSituacaocadastral(), empresa.getQualificacaodoresponsavel(), empresa.getCapitalsocial(),
				empresa.getPortedaempresa(), empresa.getOpcaopelosimplesexcluidodosimples(), empresa.getOpcaopelomei(),
				empresa.getEndereco(), empresa.getContato(), empresa.getSocio());

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

	public List<Socio> getSocio() {
		return socio;
	}

	public void setSocio(List<Socio> socio) {
		this.socio = socio;
	}

	public List<Contato> getContato() {
		return contato;
	}

	public void setContato(List<Contato> contato) {
		this.contato = contato;
	}
}