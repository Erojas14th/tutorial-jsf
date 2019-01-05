package com.erojas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.erojas.dao.PersonDAO;
import com.erojas.dao.impl.PersonDAOImpl;
import com.erojas.model.Person;

@Named
@SessionScoped
public class PersonController implements Serializable {


	private static final long serialVersionUID = 1L;
	//@Inject
	//private PersonService ps;
	private PersonDAO ps = new PersonDAOImpl();
	private List<Person> list;
	private Person person;
	
	public  PersonController() {
		list = new ArrayList<>();

		person = new Person();
		findAll();
	}

	public void findAll() {
		list = ps.findAll();
	}

	public String getOne(Integer id) {

		if (id >= 1) {
			person = ps.getOne(id);

		} else {
			person = new Person();
			person.setId(ps.generateId());
		}

		return "person_form?faces-redirect=true";

	}

	public String save() {
	
		
		if( person.getId()!=ps.generateId()) {
			ps.update(person);
			
		}else {
			ps.save(person);
		}
		
		findAll();

		return "person_list?faces-redirect=true";
	}
	public String deleteById(Integer id) {

		ps.deleteById(ps.getOne(id));
		findAll();
		return "person_list?faces-redirect=true";
	}

	// Getters and setters

	public List<Person> getList() {
		return list;
	}

	public void setLista(List<Person> list) {
		this.list = list;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
