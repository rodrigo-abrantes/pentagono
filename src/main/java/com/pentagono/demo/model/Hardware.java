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
@Table(name="tb_hardware")
@JsonIgnoreProperties("solicitacaoHardware")
public class Hardware {
	
	
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	
	
	
	
	@Column(name="tipo") // TODO
	private String tipo;
	
	
	
	
	@Column(name="preco") // TODO
	private Double preco;
	
	
	
	//FK
	@OneToMany(cascade=CascadeType.ALL, mappedBy="hardwares")
	@JsonIgnoreProperties("hardwares")
	private List<SolicitacaoHardware> solicitacaoHardware;
	
	
	
	
	public Hardware() {
		
	}

	public Hardware(int id, String tipo, Double preco) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.preco = preco;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	


}
