package com.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.bookstore.entity.Users;

/**
 * UserDao
 */
public class UserDao extends JpaDao<Users> implements GenericDao<Users> {

	public UserDao(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Users get(Object id) {
		return super.find(Users.class, id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Users.class, id);
	}

	@Override
	public List<Users> listAll() {
		return super.findWithNamedQuery("Users.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Users.countAll");
	}

}