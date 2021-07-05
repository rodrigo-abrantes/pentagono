package com.pentagono.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuario")
@JsonIgnoreProperties("solicitacoes")
public class Usuario {
	
	
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	
	@Column(name = "racf")
	private String racf;
	
	
	
	@Column(name = "nome")
	private String nome;	
	
	
	
	@Column(name = "email")
	private String email;
	
	
	
	@Column(name = "funcional")
	private String funcional;
	
	
	
	@Column(name = "senha")
	private String senha;

	
	
	//FK
	@OneToMany(cascade=CascadeType.ALL, mappedBy="usuario")
	private List<Solicitacao> solicitacoes;
	

	public Usuario() {
		
	}

	
	public List<Solicitacao> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<Solicitacao> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}
	public Usuario(int id, String racf, String nome, String email, String senha, String funcional) {
		super();
		this.id = id;
		this.racf = racf;
		this.nome = nome;
		this.email = email;
		this.funcional = funcional;
		this.senha = senha;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRacf() {
		return racf;
	}

	public void setRacf(String racf) {
		this.racf = racf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFuncional() {
		return funcional;
	}

	public void setFuncional(String funcional) {
		this.funcional = funcional;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	

	
}