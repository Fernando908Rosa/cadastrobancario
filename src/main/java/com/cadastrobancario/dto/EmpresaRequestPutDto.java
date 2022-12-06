package com.cadastrobancario.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;

import com.cadastrobancario.entity.Empresa;
import com.cadastrobancario.entity.Endereco;

public class EmpresaRequestPutDto {

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
	private EnderecoRequestDto endereco;

//	@Column(name = "contato")
//	private List<ContatoRequestDto> contato;

	public EmpresaRequestPutDto(String cnpj, String nomedaempresa, String fantasianome, Date iniciodaatividade,
			String naturezajuridica, Date situacaocadastral, String qualificacaodoresponsavel, BigDecimal capitalsocial,
			String portedaempresa, Date opcaopelosimplesexcluidodosimples, String opcaopelomei,
			EnderecoRequestDto endereco) {
		super();
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
//		this.contato = contato;
	}

	public Empresa converterEmpresaRequestDtoParaEntidadeEmpresa() {
		return new Empresa(null, cnpj, nomedaempresa, fantasianome, iniciodaatividade, naturezajuridica,
				situacaocadastral, qualificacaodoresponsavel, capitalsocial, portedaempresa,
				opcaopelosimplesexcluidodosimples, opcaopelomei, new Endereco(endereco));
	}

	public EnderecoRequestDto getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoRequestDto endereco) {
		this.endereco = endereco;
	}

//	public List<ContatoRequestDto> getContato() {
//		return contato;
//	}
//
//	public void setContato(List<ContatoRequestDto> contato) {
//		this.contato = contato;
//	}

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

}
