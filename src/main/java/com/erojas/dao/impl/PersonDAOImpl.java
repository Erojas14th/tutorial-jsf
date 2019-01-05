package com.erojas.dao.impl;


import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.erojas.dao.PersonDAO;
import com.erojas.model.Person;
@Named
@RequestScoped
public class PersonDAOImpl implements PersonDAO{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePU");
	EntityManager em = emf.createEntityManager();

	@Override
	public void save(Person person) {
		try {
		em.getTransaction().begin();
		em.persist(person);
		em.getTransaction().commit();
		}catch(Exception e) {e.printStackTrace();}
	}

	@Override
	public void update(Person person) {
		try {
		em.getTransaction().begin();
		em.merge(person);
		em.getTransaction().commit();
		}catch(Exception e) {e.printStackTrace();}
		
	}

	@Override
	public void deleteById(Person person) {
		try {
		em.getTransaction().begin();
		em.remove(person);
		em.getTransaction().commit();
	}catch(Exception e) {e.printStackTrace();}
		
	}

	@Override
	public Person getOne(Integer id) {
		Person per = new Person();
		try {

			per = em.find(Person.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return per;
	}

	@Override
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

	@Override
	public int generateId() {
		String sql = " select max(p.id)+1 from person p";
		int id=0;
		Query query = em.createQuery(sql);
		id=(int)query.getSingleResult();
		if(id==0) {
			id++;
		}
		return id;
		
	}

}
