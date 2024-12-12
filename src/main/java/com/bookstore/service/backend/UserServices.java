package com.bookstore.service.backend;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.UserDao;
import com.bookstore.entity.Users;

/**
 * UserServices
 */
public class UserServices {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private UserDao userDao;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public UserServices(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		entityManagerFactory = Persistence.createEntityManagerFactory("BooksStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		userDao = new UserDao(entityManager);
	}

	public void listUser()
			throws ServletException, IOException {
		listUser(null);

	}

	public void listUser(String message)
			throws ServletException, IOException {
		List<Users> listUsers = userDao.listAll();
		request.setAttribute("listUsers", listUsers);
		if (message != null) {
			request.setAttribute("message", message);
		}

		String listPage = "user_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);
	}

	public void createUser() throws ServletException, IOException {
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullName");
		String password = request.getParameter("password");

		Users existUser = userDao.findByEmail(email);
		if (existUser != null) {
			String message = "Could not create user. A user with email " + email + " already exists";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
		} else {
			Users newUser = new Users(email, password, fullName);
			userDao.create(newUser);
			listUser("New user created successfully");
		}

	}

	public void editUser() throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("id"));
		Users user = userDao.get(userId);
		String editPage = "user_form.jsp";
		request.setAttribute("user", user);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
		requestDispatcher.forward(request, response);
	}

	public void updateUser() throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullName");
		String password = request.getParameter("password");

		Users userById = userDao.get(userId);
		Users userByEmail = userDao.findByEmail(email);
		if (userByEmail != null && userByEmail.getUserId() != userById.getUserId()) {
			String message = "Could not update the user: The email '<i>" + email
					+ "</i>' is already used by another user";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
		} else {

			Users user = new Users(userId, email, password, fullName);
			userDao.update(user);
			String message = "User has been updated successfully";
			listUser(message);
		}

	}

}