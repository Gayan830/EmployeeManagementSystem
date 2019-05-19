package com.empmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection getConnectionToDatabase() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emoloyee_management_system_db", "root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		}

		catch (SQLException e) {
			e.printStackTrace();

		}

		if (connection != null) {
		}
		return connection;
	}
	
}
