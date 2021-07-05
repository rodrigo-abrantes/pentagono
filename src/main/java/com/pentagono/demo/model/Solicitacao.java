package com.pentagono.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_solicitacao")
public class Solicitacao {
	
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	
	@Column(name = "descricao")
	private String descricao;
	
	
	
	@Column(name = "data_solicitacao")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private Date dataSolicitacao;
	
	
	//FK
	@OneToOne
	@JoinColumn(name="id_sistema_operacional")
	private SistemaOperacional sistemaOperacional;
	

	
	//FK
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	


	//FK
	@ManyToOne
	@JoinColumn(name="id_solicitacao_status")
	private SolicitacaoStatus statusSolicitacao;
	
	
	
	//FK
	@OneToMany(cascade=CascadeType.ALL, mappedBy="solicitacao")	
	private List<SolicitacaoSoftware> solicitacaoSoftware;
	
	
	
	//FK
	@OneToMany(cascade=CascadeType.ALL, mappedBy="solicitacao")
	private List<SolicitacaoHardware> solicitacaoHardware;
	
	
	
	
	
	
	
	
	
	public Solicitacao() {
		
	}

	public Solicitacao(int id, String descricao, Date dataSolicitacao, Usuario usuario,
			SistemaOperacional sistemaOperacional, SolicitacaoStatus statusSolicitacao) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.dataSolicitacao = dataSolicitacao;
		this.usuario = usuario;
		this.sistemaOperacional = sistemaOperacional;
		this.statusSolicitacao = statusSolicitacao;
	}

	
	
	public List<SolicitacaoSoftware> getSolicitacaoSoftware() {
		return solicitacaoSoftware;
	}

	public void setSolicitacaoSoftware(List<SolicitacaoSoftware> solicitacaoSoftware) {
		this.solicitacaoSoftware = solicitacaoSoftware;
	}

	public List<SolicitacaoHardware> getSolicitacaoHardware() {
		return solicitacaoHardware;
	}

	public void setSolicitacaoHardware(List<SolicitacaoHardware> solicitacaoHardware) {
		this.solicitacaoHardware = solicitacaoHardware;
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

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public SistemaOperacional getSistemaOperacional() {
		return sistemaOperacional;
	}

	public void setSistemaOperacional(SistemaOperacional sistemaOperacional) {
		this.sistemaOperacional = sistemaOperacional;
	}

	public SolicitacaoStatus getStatusSolicitacao() {
		return statusSolicitacao;
	}

	public void setStatusSolicitacao(SolicitacaoStatus statusSolicitacao) {
		this.statusSolicitacao = statusSolicitacao;
	}
	
	
	
	
}
