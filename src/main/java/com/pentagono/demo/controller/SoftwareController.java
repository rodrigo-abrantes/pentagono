package com.pentagono.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pentagono.demo.dao.SoftwareDAO;
import com.pentagono.demo.model.Software;

@CrossOrigin("*")
@RestController
public class SoftwareController {
	
	@Autowired
	SoftwareDAO dao;
	
	@GetMapping("/software/{id}")
	public ResponseEntity<Software> getSoftwareById(@PathVariable int id){
		Software sw = dao.findById(id).orElse(null);
		if(sw == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(sw);
		}
	}
	
	@GetMapping("/software/all")
	public ResponseEntity<ArrayList<Software>> getAllSoftware(){
		ArrayList<Software> list = (ArrayList<Software>) dao.findAll();
		if (list.size() == 0) {
			return ResponseEntity.status(403).build();
		}else {
			return ResponseEntity.ok(list);
		}
	}
}
