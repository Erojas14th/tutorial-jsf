package com.erojas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity(name="person")
@Table(name="person")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;
	@Column(name="name")
	private String name;
	
	public Person() {}
	
	public Person(Integer id, String name) {
		
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}



}
