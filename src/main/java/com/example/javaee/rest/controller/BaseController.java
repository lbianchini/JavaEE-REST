package com.example.javaee.rest.controller;

import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import com.example.javaee.rest.dao.BaseDao;
import com.example.javaee.rest.model.BaseModel;

@TransactionManagement(TransactionManagementType.CONTAINER)
public abstract class BaseController<T extends BaseModel> {
	
	@Inject
	private BaseDao<T> dao;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(T entity) {
		dao.save(entity);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<T> getAll(Class<T> entity) {
		return dao.getAll(entity);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public T getById(Class<T> entity, Object id) {
		return dao.getById(entity, id);
	}

	

}
