package com.pentagono.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.pentagono.demo.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{
	public Usuario findByRacfAndSenha(String racf, String senha);
}
