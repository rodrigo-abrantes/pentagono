package com.pentagono.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pentagono.demo.dao.SistemaOperacionalDAO;
import com.pentagono.demo.model.SistemaOperacional;

@CrossOrigin("*")
@RestController
public class SistemaOperacionalController {

	@Autowired
	private SistemaOperacionalDAO dao;
	
	@GetMapping("/so/{id}")
	public ResponseEntity<SistemaOperacional> getSOById(@PathVariable int id){
		SistemaOperacional so = dao.findById(id).orElse(null);		
		if (so==null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(so);
		}
	}
	
	@GetMapping("/so/all")
	public ResponseEntity<ArrayList<SistemaOperacional>> getAllSO(){
		ArrayList<SistemaOperacional> list = (ArrayList<SistemaOperacional>) dao.findAll();
		if(list.size()==0) {
			return ResponseEntity.status(404).build();
		}else {
			return ResponseEntity.ok(list);
		}
		
	}
}

