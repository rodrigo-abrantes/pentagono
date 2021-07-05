package com.pentagono.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.pentagono.demo.model.Hardware;

public interface HardwareDAO extends CrudRepository<Hardware, Integer>{

}
