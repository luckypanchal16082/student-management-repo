package com.lucky.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lucky.dao.UserDAO;
import com.lucky.model.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User user = new User(name, email, password);

		UserDAO dao = new UserDAO();

		
		
		try {
			boolean result = dao.registerUser(user);

			if (result) {
				response.sendRedirect(request.getContextPath() + "/success.jsp");

			} else {
				response.sendRedirect(request.getContextPath() + "/error.jsp");

			}

		} catch (SQLException e) {
			throw new ServletException("registration failed! ", e);

		}

	}

}
