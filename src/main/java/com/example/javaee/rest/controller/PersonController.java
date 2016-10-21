package com.example.javaee.rest.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.example.javaee.rest.dao.PersonDao;
import com.example.javaee.rest.model.Person;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PersonController {

	@EJB
	private PersonDao personDao;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Person person) {
		personDao.save(person);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Person> getPersonList() {
		return personDao.getPersonList();
	}
	
}
