package com.bookstore.controller.admin.users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.service.backend.UserServices;

/**
 * EditUserServlet
 */
@WebServlet("/admin/edit_user")
public class EditUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserServices userServices = new UserServices(request, response);
		userServices.editUser();
	}
}