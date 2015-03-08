package com.emas.jpa.repository;

import java.util.List;

public interface IGenericRepository<T> 
{
	public T findById(final Integer id);
	
	public List<T> findAll(); 
	
	public void create(final T entity);
	
	public T update(final T entity);
	
	public void delete(final T  entity);
	
	public void deleteById(final Integer entityId);
	
	public List<T> findBy(String parameter);
	
	public List<T> findBy( String column, String value );
	
}
