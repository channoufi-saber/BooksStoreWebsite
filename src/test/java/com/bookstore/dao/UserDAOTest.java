package com.bookstore.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bookstore.entity.Users;

public class UserDAOTest {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static UserDAO userDAO;

	@BeforeClass
	public static void setupClass() {
		entityManagerFactory = Persistence.createEntityManagerFactory("BooksStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		userDAO = new UserDAO(entityManager);
	}

	public void testCreateUsers() {
		Users user1 = new Users();
		user1.setEmail("nigel.farage@brexit.uk");
		user1.setFullName("Niger Farage");
		user1.setPassword("aaaa");
		user1 = userDAO.create(user1);
	}

	// @Test(expectedExceptions = PersistenceException.class)
	public void testCreateUsersFieldsNotSet() {
		Users user1 = new Users();
		user1 = userDAO.create(user1);
	}

	@Test
	public void testUpdateUsers() {
		Users user = new Users();
		user.setUserId(27);
		user.setEmail("drade@google.com");
		user.setFullName("nnnnn");
		user.setPassword("okokobioko");

		user = userDAO.update(user);
	}

	@AfterClass
	public static void tearDownClass() {
		entityManager.close();
		entityManagerFactory.close();
	}

}