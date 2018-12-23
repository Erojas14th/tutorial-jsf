package com.erojas.service;

import java.util.List;

import com.erojas.model.Persona;

public interface PersonaService {
	int save(Persona persona);
	int update(Persona persona);
	int deleteById(Integer id);
	Persona getOne(Integer id);
	List<Persona> findAll();
}
