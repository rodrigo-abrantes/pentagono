package com.pentagono.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_software")
@JsonIgnoreProperties({"sistemaOperacional", "solicitacaoSoftware"})
public class Software {
	
	
	
	@Column(name="id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	
	
	
	@Column(name = "nome")
	private String nome;
	
	
	
	@Column(name = "preco_core")
	private Double precoCore;
	
	
	
	@Column(name = "preco_call")
	private Double precoCall;
	
	
	
	@Column(name = "preco_memoria")
	private Double precoMemoria;
	
	
	
	@Column(name = "preco_licenca")
	private Double precoLicenca;
	
	
	
	@Column(name = "descricao")
	private String descricao;
	
	
	
	//fk
	@OneToOne
	@JoinColumn(name="id_sistema_operacional")
	private SistemaOperacional sistemaOperacional;
	
	
	
	//fk
	@OneToMany (cascade=CascadeType.ALL, mappedBy="software")
	private List<SolicitacaoSoftware> solicitacaoSoftware;
	
	
	
	
	
	
	
	
	
	
	public Software() {
		
	}


	public Software(int id, String nome, Double precoCore, Double precoCall, Double precoMemoria,
			Double precoLicenca, String descricao, SistemaOperacional sistemaOperacional) {
		super();
		this.id = id;
		this.nome = nome;
		this.precoCore = precoCore;
		this.precoCall = precoCall;
		this.precoMemoria = precoMemoria;
		this.precoLicenca = precoLicenca;
		this.descricao = descricao;
		this.sistemaOperacional = sistemaOperacional;
	}

	
	public SistemaOperacional getSistemaOperacional() {
		return sistemaOperacional;
	}


	public void setSistemaOperacional(SistemaOperacional sistemaOperacional) {
		this.sistemaOperacional = sistemaOperacional;
	}
	
	
	public List<SolicitacaoSoftware> getSolicitacaoSoftware() {
		return solicitacaoSoftware;
	}


	public void setSolicitacaoSoftware(List<SolicitacaoSoftware> solicitacaoSoftware) {
		this.solicitacaoSoftware = solicitacaoSoftware;
	}

	

	public int getIdSoftware() {
		return id;
	}


	public void setIdSoftware(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Double getPrecoCore() {
		return precoCore;
	}


	public void setPrecoCore(Double precoCore) {
		this.precoCore = precoCore;
	}


	public Double getPrecoCall() {
		return precoCall;
	}


	public void setPrecoCall(Double precoCall) {
		this.precoCall = precoCall;
	}


	public Double getPrecoMemoria() {
		return precoMemoria;
	}


	public void setPrecoMemoria(Double precoMemoria) {
		this.precoMemoria = precoMemoria;
	}


	public Double getPrecoLicenca() {
		return precoLicenca;
	}


	public void setPrecoLicenca(Double precoLicenca) {
		this.precoLicenca = precoLicenca;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
