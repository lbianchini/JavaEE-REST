package com.example.javaee.rest.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.example.javaee.rest.dao.PersonDao;
import com.example.javaee.rest.model.Person;

@Stateless
public class PersonController {

	@EJB
	private PersonDao personDao;
	
	public void save(Person person) {
		personDao.save(person);
	}

	public List<Person> getPersonList() {
		return personDao.getPersonList();
	}
	
}
