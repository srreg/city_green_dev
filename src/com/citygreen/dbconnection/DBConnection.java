package com.citygreen.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
public static Connection getDBConnection() {
		
		Connection connection = null;
		
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/citygreen_dev", "root", "Admin@123");
	}catch(ClassNotFoundException e) {
		System.out.println("JDBC Driver is not found here.");
		e.printStackTrace();
		return null;
	} catch (SQLException e) {
		System.out.println("Connection failed \t Please try again");
		e.printStackTrace();
		return null;
	}
	
	return connection;

}

}
