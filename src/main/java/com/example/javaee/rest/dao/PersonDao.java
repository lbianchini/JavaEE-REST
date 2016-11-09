package com.example.javaee.rest.dao;

import javax.ejb.Stateless;

import com.example.javaee.rest.model.Person;

@Stateless
public class PersonDao extends BaseDao<Person>{
	
	public PersonDao() {}
	
}
