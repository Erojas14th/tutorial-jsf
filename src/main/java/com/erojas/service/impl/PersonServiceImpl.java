package com.erojas.service.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.erojas.dao.PersonDAO;
import com.erojas.model.Person;
import com.erojas.service.PersonService;
@Named
@RequestScoped
public class PersonServiceImpl implements PersonService{
	@Inject
	private PersonDAO dao;
	@Override
	public void save(Person person) {
		dao.save(person);
		
	}

	@Override
	public void update(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Person getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int generateId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
