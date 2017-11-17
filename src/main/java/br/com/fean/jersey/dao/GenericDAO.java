package br.com.fean.jersey.dao;

import java.util.List;

public interface GenericDAO<T> {

	public void persist(T entity);
	
	public Boolean update(T entityModified);
	
	public T findById(Integer id);
	
	public void delete(T entity);
 
    public List<T> findAll();
 
    public void deleteAll();
}
