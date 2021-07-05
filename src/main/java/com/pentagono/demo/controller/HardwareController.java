package com.pentagono.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pentagono.demo.dao.HardwareDAO;
import com.pentagono.demo.model.Hardware;

@CrossOrigin("*")
@RestController
public class HardwareController {
	
	@Autowired
	public HardwareDAO dao;
	
	
	@GetMapping("/hardware/{id}")
	public ResponseEntity<Hardware> getHardwareById(@PathVariable int id){
		Hardware hw = dao.findById(id).orElse(null);
		if(hw == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(hw);
		}
	}
	
	@GetMapping("/hardware/all")
	public ResponseEntity<ArrayList<Hardware>> getAllHardaware(){
		ArrayList<Hardware> list = (ArrayList<Hardware>) dao.findAll();
		if (list.size() == 0) {
			return ResponseEntity.status(403).build();
		}else {
			return ResponseEntity.ok(list);
		}
	}
	
	
}
