package com.bookstore.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UsersTest {

	public void UserssTest() {
		Users user1 = new Users();
		user1.setEmail("bill.gates@microsoft.com");
		user1.setFullName("Bill Gates3");
		user1.setPassword("wordwordword");

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BooksStoreWebsite");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(user1);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		System.out.println("A Users object was persisted");
	}

	public static void main(String[] args) {
		Users user1 = new Users();
		user1.setEmail("bill.gates@microsoft.com");
		user1.setFullName("Bill Gates");
		user1.setPassword("wordwordword");

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BooksStoreWebsite");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(user1);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		System.out.println("A Users object was persisted");
	}

}
