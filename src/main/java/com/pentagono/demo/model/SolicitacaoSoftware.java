package com.pentagono.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_solicitacao_software")
public class SolicitacaoSoftware {
	
	
	
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	

	
	@ManyToOne
	@JoinColumn(name="id_software")
	private Software software;
	


	@ManyToOne
	@JoinColumn(name="id_solicitacao")
	private Solicitacao solicitacao;

	
	
	@Column(name = "custo")
	private Double custo;
	
	
	
	@Column(name = "descricao")
	private String descricao;
	
	
	
	
	
	
	
	public SolicitacaoSoftware() {
		
	}

	public SolicitacaoSoftware(int id, Software software, Solicitacao solicitacao, Double custo,
			String descricao) {
		super();
		this.id = id;
		this.software = software;
		this.solicitacao = solicitacao;
		this.custo = custo;
		this.descricao = descricao;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Software getSoftware() {
		return software;
	}

	public void setSoftware(Software software) {
		this.software = software;
	}

	public Solicitacao getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
