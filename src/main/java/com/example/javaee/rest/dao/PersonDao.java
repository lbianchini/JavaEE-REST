package com.example.javaee.rest.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.javaee.rest.model.Person;

@Stateless
public class PersonDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void save(Person person) {
		entityManager.persist(person);
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> getPersonList() {
		return (List<Person>)entityManager.createQuery("from Person").getResultList();
	}
}
