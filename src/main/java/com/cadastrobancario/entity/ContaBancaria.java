package com.cadastrobancario.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cadastrobancario.enuns.Transacao;

@Entity
@Table(name = "tb_contabancaria")
public class ContaBancaria {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long agencia;
	private BigDecimal saldo;
	private String numerodaconta;

	@Column(name = "transacaogenerico")
	@Enumerated(EnumType.STRING)
	private Transacao transacaogenerico;

	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
	private Usuario usuario;
	private String titulo;
	private String descricao;

	public ContaBancaria(Long id, Long agencia, BigDecimal saldo, String numerodaconta, Usuario usuario) {
		super();
		this.id = id;
		this.agencia = agencia;
		this.saldo = saldo;
		this.numerodaconta = numerodaconta;
		this.usuario = usuario;
	}

	public ContaBancaria(Long id, Long agencia, BigDecimal saldo, String numerodaconta) {
		super();
		this.id = id;
		this.agencia = agencia;
		this.saldo = saldo;
		this.numerodaconta = numerodaconta;
	}

	public ContaBancaria() {
	}

	public ContaBancaria(Long idContaBancaria) {
		super();
		this.id = idContaBancaria;

	}

	public ContaBancaria(Long id, Long agencia, BigDecimal saldo, String numerodaconta,	Transacao transacaogenerico) {
		super();
		this.id = id;
		this.agencia = agencia;
		this.saldo = saldo;
		this.numerodaconta = numerodaconta;
		this.transacaogenerico = transacaogenerico;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAgencia() {
		return agencia;
	}

	public void setAgencia(Long agencia) {
		this.agencia = agencia;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getNumerodaconta() {
		return numerodaconta;
	}

	public void setNumerodaconta(String numerodaconta) {
		this.numerodaconta = numerodaconta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Transacao getTransacaogenerico() {
		return transacaogenerico;
	}

	public void setTransacaogenerico(Transacao transacaogenerico) {
		this.transacaogenerico = transacaogenerico;
	}
	
	

}
