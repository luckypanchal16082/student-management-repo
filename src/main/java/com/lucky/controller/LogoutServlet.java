package com.lucky.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request , HttpServletResponse response) throws SecurityException, IOException{
		
		  // Get the existing session without creating a new one
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			session.invalidate();
		}
		
		// Redirect the user to the login page
		response.sendRedirect(
				request.getContextPath() + "/login.jsp");
		
	}
	
}
