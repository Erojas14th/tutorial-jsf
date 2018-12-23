package com.erojas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.erojas.model.Persona;
import com.erojas.service.PersonaService;
import com.erojas.service.impl.PersonaServiceImpl;

@ManagedBean
@SessionScoped
public class PersonaBean {

	private PersonaServiceImpl  personaService;
	private List<Persona> lista;
	private Persona persona;
	
	
	
	public PersonaBean() {
		lista=new ArrayList<>();
		personaService= new PersonaServiceImpl();
		persona=new Persona();
		findAll();
	}
	
	public void findAll() {
		lista = personaService.findAll();
	}
	
	public String  getOne(Integer id) {
		
		
		if(id>=1){
			persona = personaService.getOne(id);
			
		}else {
			persona= new Persona();
		}
	
		
		return "persona_form?faces-redirect=true";
		
	}
	

	
	public String save() {
		
		
		String direccion="";
		
		if(persona.getId()!=null) {
			if(personaService.save(persona)>=1) {
				// mensaje save
			}
			if(personaService.update(persona)>=1){
				// mensaje update
			}
		}
		
		findAll();

		return "index?faces-redirect=true";
	}
	
	public String deleteById(Integer id) {
		String direccion="";
		if(personaService.deleteById(id)>=1) {
			direccion= "index?faces-redirect=true";
		}
		findAll();
		return direccion;
	}

	public PersonaService getPersonaService() {
		return personaService;
	}

	

	public List<Persona> getLista() {
		return lista;
	}

	public void setLista(List<Persona> lista) {
		this.lista = lista;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	

}
