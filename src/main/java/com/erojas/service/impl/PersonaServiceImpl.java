package com.erojas.service.impl;

import java.util.List;

import com.erojas.dao.PersonaDAO;
import com.erojas.dao.PersonaDAOImpl;
import com.erojas.model.Persona;
import com.erojas.service.PersonaService;

public class PersonaServiceImpl implements PersonaService{

	private PersonaDAO personaDAO;
	public PersonaServiceImpl() {
		personaDAO=new PersonaDAOImpl();
	}
	
	@Override
	public int save(Persona persona) {
		// TODO Auto-generated method stub
		return personaDAO.save(persona);
	}

	@Override
	public int update(Persona persona) {
		// TODO Auto-generated method stub
		return personaDAO.update(persona);
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return personaDAO.deleteById(id);
	}

	@Override
	public Persona getOne(Integer id) {
		// TODO Auto-generated method stub
		return personaDAO.getOne(id);
	}

	@Override
	public List<Persona> findAll() {
		// TODO Auto-generated method stub
		return personaDAO.findAll();
	}

	@Override
	public int generateId() {
		// TODO Auto-generated method stub
		return personaDAO.generateId();
	}
	

}
