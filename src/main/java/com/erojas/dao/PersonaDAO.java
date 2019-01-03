package com.erojas.dao;

import java.util.List;

import com.erojas.model.Persona;

public interface PersonaDAO {
	int save(Persona persona);
	int update(Persona persona);
	int deleteById(Integer id);
	Persona getOne(Integer id);
	List<Persona> findAll();
	int generateId();
}
