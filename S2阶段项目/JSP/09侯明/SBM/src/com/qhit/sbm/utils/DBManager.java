package com.qhit.sbm.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	private static Connection con;
	private static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String url = "jdbc:sqlserver://localhost:1433;databaseName=Supermarket";
	private static String userName = "sa";
	private static String userPassword = "123456";
	
	public static Connection getConnection(){
		try {
			Class.forName(driverName);
			con=DriverManager.getConnection(url, userName, userPassword);
			return con;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static void close(Statement statement,Connection con){
		try {
			statement.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
