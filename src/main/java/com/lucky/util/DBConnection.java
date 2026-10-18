package com.lucky.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static final String url = "jdbc:mysql://localhost:3306/registration_db";
	
	private static final String username = "root";
	
	private static final String password = "root";
	
	public static Connection getConnection() throws SQLException{
		
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        throw new SQLException("MySQL JDBC Driver not found!", e);
	    }
		
		return DriverManager.getConnection(url,username,password);
	}
	
	
}
