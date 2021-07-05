package com.pentagono.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.pentagono.demo.model.Software;

public interface SoftwareDAO extends CrudRepository<Software, Integer>{

}
