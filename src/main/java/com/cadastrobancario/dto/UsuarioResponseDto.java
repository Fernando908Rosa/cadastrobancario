package com.cadastrobancario.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.cadastrobancario.entity.Usuario;
import com.cadastrobancario.enuns.Genero;

public class UsuarioResponseDto {

	@Column(name = "id")
	private Long id;

	@Column(name = "nome")
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

	@Column(name = "email")
	private String email;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "genero")
	@Enumerated(EnumType.STRING)
	private Genero genero;

	public UsuarioResponseDto(Long id, String nome, String sobrenome, Date datanascimento, Integer cpf, String nomemae,
			String nomepai, String endereco, Genero genero, String telefone, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.datanascimento = datanascimento;
		this.cpf = cpf;
		this.nomemae = nomemae;
		this.nomepai = nomepai;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
		this.genero = genero;
	}

	public static UsuarioResponseDto converterUsuarioParaUsuarioResponseDto(Usuario usuario) {
		return new UsuarioResponseDto(usuario.getId(), usuario.getNome(), usuario.getSobrenome(),
				usuario.getDatanascimento(), usuario.getCpf(), usuario.getNomemae(), usuario.getNomepai(),
				usuario.getEndereco(), usuario.getGenero(), usuario.getEmail(), usuario.getTelefone());

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}
