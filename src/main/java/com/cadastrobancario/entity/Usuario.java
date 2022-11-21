package com.cadastrobancario.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cadastrobancario.enuns.Genero;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String sobrenome;
	private Date datanascimento;
	private Integer cpf;
	private String nomemae;
	private String nomepai;
	private String endereco;
	private Genero genero;
	private String email;
	private String telefone;

	public Usuario() {
	}

	public Usuario(Long id) {
		this.id = id;
	}

	public Usuario(Long id, String nome, String sobrenome, Date datanascimento, Integer cpf, String nomemae,
			String nomepai, String endereco, Genero genero, String email, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.datanascimento = datanascimento;
		this.cpf = cpf;
		this.nomemae = nomemae;
		this.nomepai = nomepai;
		this.endereco = endereco;
		this.genero = genero;
		this.email = email;
		this.telefone = telefone;

	}

	@OneToOne(mappedBy = "usuario")
	private ContaBancaria contabancaria;

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

	public ContaBancaria getContabancaria() {
		return contabancaria;
	}

	public void setContabancaria(ContaBancaria contabancaria) {
		this.contabancaria = contabancaria;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", datanascimento="
				+ datanascimento + ", cpf=" + cpf + ", nomemae=" + nomemae + ", nomepai=" + nomepai + ", endereco="
				+ endereco + ", genero=" + genero + ", email=" + email + ", telefone=" + telefone + ", contabancaria="
				+ contabancaria + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(contabancaria, cpf, datanascimento, email, endereco, genero, id, nome, nomemae, nomepai,
				sobrenome, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(contabancaria, other.contabancaria) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(datanascimento, other.datanascimento) && Objects.equals(email, other.email)
				&& Objects.equals(endereco, other.endereco) && genero == other.genero && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(nomemae, other.nomemae)
				&& Objects.equals(nomepai, other.nomepai) && Objects.equals(sobrenome, other.sobrenome)
				&& Objects.equals(telefone, other.telefone);
	}

}
