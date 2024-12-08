package com.bookstore.dao;

import java.util.List;

/**
 * GenericDao
 */
public interface GenericDao<E> {

	E create(E t);
	E update(E t);
	E get(Object id);
	void delete(Object id);
	List<E> listAll();
	long count();
}