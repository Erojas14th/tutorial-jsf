package com.erojas.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.Test;

import com.erojas.model.Person;
import com.erojas.service.PersonService;
import com.erojas.service.impl.PersonServiceImpl;

public class TestApp {

	
	@PersistenceContext(unitName = "EmployeePU")
	EntityManager em;
	
	List<Person> list = new ArrayList<>();



	public List<Person> findAll() {
		List<Person> lista = null;
		try {

			Query query = em.createQuery("FROM person");
			lista = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	@Test
	public void test() {
		findAll();
	}
}
