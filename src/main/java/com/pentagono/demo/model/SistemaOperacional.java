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
@Table(name = "tb_sistema_operacional")
@JsonIgnoreProperties({"solicitacoes", "software"})
public class SistemaOperacional {
	
	
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	
	
	
	@Column(name = "nome")
	private String nome;
	
	
	
	@Column(name = "versao")
	private String versao;
	
	
	
	@Column(name = "preco")
	private Double preco;
	
	

	//FK
	@OneToMany (cascade=CascadeType.ALL, mappedBy="sistemaOperacional")	
	private List<Solicitacao> solicitacoes;

	

	//FK	
	@OneToMany (cascade=CascadeType.ALL, mappedBy="sistemaOperacional")
	private List<Software> software;
	
	
	
	
	
	
	
	public SistemaOperacional() {
		
	}

	public SistemaOperacional(int id, String nome, String versao, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.versao = versao;
		this.preco = preco;
	}

	
	
	public List<Software> getSoftware() {
		return software;
	}

	public void setSoftware(List<Software> software) {
		this.software = software;
	}

	public List<Solicitacao> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<Solicitacao> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	

}
