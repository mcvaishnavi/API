package com.quinnox.shoppingservice;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

	
	public static Connection getConnection() throws SQLException {
		String JdbcURL = "jdbc:mysql://localhost:3306/items?" + "autoReconnect=true&useSSL=false";
	      String Username = "root";
	      String password = "Password@1";
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(JdbcURL, Username, password);
			System.out.println("Your JDBC URL is as follows:" + JdbcURL);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return conn;
	}
}


