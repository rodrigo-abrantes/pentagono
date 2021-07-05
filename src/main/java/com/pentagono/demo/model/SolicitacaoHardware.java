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
@Table(name = "tb_solicitacao_hardware")
public class SolicitacaoHardware {

	
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	
	@Column(name = "custo")
	private Double custo;
	
	
	
	@Column(name = "quantidade")
	private int quantidade;
	
	
	
	//fk
	@ManyToOne
	@JoinColumn(name="id_hardware")
	private Hardware hardwares;
	

	
	//fk
	@ManyToOne
	@JoinColumn(name="id_solicitacao")
	private Solicitacao solicitacao;
	
	
	
	public SolicitacaoHardware() {
		
	}

	public SolicitacaoHardware(int id, Hardware hardwares, Solicitacao solicitacao, Double custo,
			int quantidade) {
		super();
		this.id = id;
		this.hardwares = hardwares;
		this.solicitacao = solicitacao;
		this.custo = custo;
		this.quantidade = quantidade;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Hardware getHardwares() {
		return hardwares;
	}

	public void setHardwares(Hardware hardwares) {
		this.hardwares = hardwares;
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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	
	

}
