package com.bookstore.service.backend;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.dao.UserDao;
import com.bookstore.entity.Users;

/**
 * UserServices
 */
public class UserServices {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private UserDao userDao;

	public UserServices() {
		entityManagerFactory = Persistence.createEntityManagerFactory("BooksStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		userDao = new UserDao(entityManager);
	}

	public List<Users> listUser() {
		List<Users> listUsers = userDao.listAll();
		return listUsers;
	}

}