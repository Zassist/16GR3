package com.qhit.grsb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static void main(String[] args) {
		
		System.out.println(getConnection());
	}

	public static Connection getConnection(){
		
		Connection conn = null ; 
		String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=employee";
		String user = "sa";
		String password = "sa";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			try {
				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
