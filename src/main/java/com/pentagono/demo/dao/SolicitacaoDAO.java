package com.pentagono.demo.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.pentagono.demo.model.Solicitacao;

public interface SolicitacaoDAO extends CrudRepository<Solicitacao, Integer> {

	public ArrayList<Solicitacao> findByUsuario(int id_usuario);
	//public ArrayList<Solicitacao> findByStatusUsuario(int id_usuario, String status);
}
