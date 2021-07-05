package com.pentagono.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pentagono.demo.dao.SolicitacaoDAO;
import com.pentagono.demo.model.Solicitacao;

@CrossOrigin("*")
@RestController
public class SolicitacaoController {

	@Autowired
	private SolicitacaoDAO dao;
	/*
	//Metodo que busca todas as solicitações abertas por um usuário
	@GetMapping("/solicitacoes/{id_usuario}")
	public ResponseEntity<ArrayList<Solicitacao>> getSolicitacaoByIdUsuario(@PathVariable int id_usuario){
		ArrayList<Solicitacao> list = (ArrayList<Solicitacao>) dao.findByUsuario(id_usuario);
		if(list.size() == 0 ) {
			return ResponseEntity.status(403).build();
		}else {
			return ResponseEntity.ok(list);
		}
	}
	
	//Metodo que busca uma solicitação pelo seu ID
	@GetMapping("/solicitacao/{id}")
	public ResponseEntity<Solicitacao> getSolicitacaoById(@PathVariable int id){
		Solicitacao solicitacao = dao.findById(id).orElse(null);
		if(solicitacao == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(solicitacao);
		}
	}
	
	//Metodo que busca uma solicitação pelo seu status e o id do usuario
	@GetMapping("/solicitacao/usuario/{id_usuario},{status}")
	public ResponseEntity<ArrayList<Solicitacao>> getSolicitacaoByStatusUsuario(@PathVariable int id_usuario, String status){
		ArrayList<Solicitacao> list = (ArrayList<Solicitacao>) dao.findByStatusUsuario(id_usuario, status);
		if(list.size() == 0) {
			return ResponseEntity.status(403).build();	
		}else {
			return ResponseEntity.ok(list);
		}
	
		
	}
	*/
}
