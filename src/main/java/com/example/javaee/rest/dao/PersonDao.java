package com.example.javaee.rest.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.javaee.rest.interceptor.LogInterceptor;
import com.example.javaee.rest.model.Person;

@Stateless
@Interceptors({LogInterceptor.class})
public class PersonDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void save(Person person) {
		entityManager.persist(person);
	}
	
	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	@SuppressWarnings("unchecked")
	public List<Person> getPersonList() {
		return (List<Person>)entityManager.createQuery("from Person").getResultList();
	}
}
