package com.example.javaee.rest.dao;

import javax.ejb.Stateless;

import com.example.javaee.rest.model.Country;

@Stateless
public class CountryDao extends BaseDao<Country>{
	
	public CountryDao() { }
	
}
