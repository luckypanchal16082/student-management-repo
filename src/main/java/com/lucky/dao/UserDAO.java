package com.lucky.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.lucky.model.User;
import com.lucky.util.DBConnection;

public class UserDAO {

	public boolean registerUser(User user) throws SQLException {

		String sql = "INSERT INTO users(name,email,password) values(?,?,?)";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());

			return ps.executeUpdate() > 0;
		}

	}
}
