package com.cadastrobancario.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.validator.constraints.Length;

import com.cadastrobancario.entity.Usuario;
import com.cadastrobancario.enuns.Genero;

public class UsuarioRequestDto {

	@Column(name = "id")
	private Long id;

	@Column(name = "nome")
	@Length(min = 5, max = 70, message = "digite nome corretamente entre 5 a 70 caracteres")
	private String nome;

	@Column(name = "sobrenome")
	private String sobrenome;

	@Column(name = "datanascimento")
	private Date datanascimento;

	@Column(name = "cpf")
	private Integer cpf;

	@Column(name = "nomemae")
	private String nomemae;

	@Column(name = "nomepai")
	private String nomepai;

	@Column(name = "endereco")
	private String endereco;

	@Column(name = "genero")
	@Enumerated(EnumType.STRING)
	private Genero genero;

	public Usuario converterUsuarioRequestDtoParaEntidadeUsuario() {
		return new Usuario(null, nome, sobrenome, datanascimento, cpf, nomemae, nomepai, endereco, genero);

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Date getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public String getNomemae() {
		return nomemae;
	}

	public void setNomemae(String nomemae) {
		this.nomemae = nomemae;
	}

	public String getNomepai() {
		return nomepai;
	}

	public void setNomepai(String nomepai) {
		this.nomepai = nomepai;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}
