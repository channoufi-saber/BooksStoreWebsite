package com.bookstore.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CategoryTest {

	public void UserssTest() {
		Category category = new Category("Core Java");

		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("BooksStoreWebsite");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(category);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();

		System.out.println("A Category object was persisted");
	}

}