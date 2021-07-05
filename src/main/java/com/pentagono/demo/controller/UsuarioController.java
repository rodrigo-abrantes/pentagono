package com.pentagono.demo.controller;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pentagono.demo.dao.UsuarioDAO;
import com.pentagono.demo.model.Usuario;

@CrossOrigin("*")
@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO dao;

	@PostMapping("/login")
	public ResponseEntity<Usuario> login(@RequestBody Usuario usuario){
		Usuario usuarioLogado=dao.findByRacfAndSenha(usuario.getRacf(), usuario.getSenha());
		if (usuarioLogado==null) {
			return ResponseEntity.status(403).build();
		}else {
			return ResponseEntity.ok(usuarioLogado);
		}
	}
	
}