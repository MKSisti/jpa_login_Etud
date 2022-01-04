package com.TB.spring.DAO;

import java.util.List;


public interface IGenericDAO<T,U> {
	public void save(T t);
	public List<T> findAll();
	public T findById(U id);
	public void update(T t);
	public void deleteById(U id);
}
