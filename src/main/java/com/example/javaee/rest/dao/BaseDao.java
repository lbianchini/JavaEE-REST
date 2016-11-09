package com.example.javaee.rest.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.javaee.rest.interceptor.LogInterceptor;
import com.example.javaee.rest.model.BaseModel;

@Stateless
@Interceptors({LogInterceptor.class})
public abstract class BaseDao<T extends BaseModel> {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void save(T entity) {
		entityManager.persist(entity);
	}
	
	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	@SuppressWarnings("unchecked")
	public List<T> getAll(Class<T> entity) {
		return (List<T>)entityManager.createQuery("from " + entity.getSimpleName()).getResultList();
	}
	
	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public T getById(Class<T> entity, Object id) {
		return entityManager.find(entity, id);
	}

}
