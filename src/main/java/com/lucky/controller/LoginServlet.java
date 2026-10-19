package com.lucky.controller;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lucky.util.DBConnection;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws SecurityException, IOException, ServletException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		String sql_statement = "SELECT id,name,email FROM users where email = ? and password = ?";

		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql_statement)) {

			ps.setString(1, email);
			ps.setString(2, password);

			try (ResultSet rs = ps.executeQuery()) {

				if (rs.next()) {

					// Create a new session after successful login
					HttpSession session = request.getSession(true);

					// Prevent session fixation
					request.changeSessionId();

					// user details after login
					session.setAttribute("userid", rs.getInt("id"));
					session.setAttribute("username", rs.getString("name"));
					session.setAttribute("useremail", rs.getString("email"));
					
					response.sendRedirect(request.getContextPath() + "/welcome.jsp");

				} else {
					// Invalid email or password
					request.setAttribute("errorMessage", "Invalid email or password!");

					request.getRequestDispatcher("/login.jsp").forward(request, response);

				}
			}

		} catch (Exception e) {

			getServletContext().log("Login database error", e);

			response.sendRedirect(request.getContextPath() + "/error.jsp");
		}
	}
}
