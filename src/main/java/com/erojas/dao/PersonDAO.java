package com.erojas.dao;

import java.util.List;

import com.erojas.model.Person;

public interface PersonDAO {
	void save(Person person);
	void update(Person person);
	void deleteById(Person person);
	Person getOne(Integer id);
	List<Person> findAll();
	int generateId();
}
