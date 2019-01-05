package com.erojas.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class NavigationController implements Serializable {

	
	private static final long serialVersionUID = 1L;
	public String homePersistence() {
		
		
		return "person_list";
	}
	public String homeJdbc() {
		
		
		return "persona_list";
	}
}
