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

@Entity
@Table(name = "tb_solicitacao_status")
public class SolicitacaoStatus {
	
	
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	
	@Column(name = "descricao")
	private String descricao;
	
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="statusSolicitacao")	
	private List<Solicitacao> solicitacoes;
	
	
	
	
	
	

	public SolicitacaoStatus() {
		
	}

	public SolicitacaoStatus(int id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

}
