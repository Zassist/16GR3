package com.qhit.sbm.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DBManager {
	private static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=db_sbm";
	private static String usename = "sa";
	private static String password = "123456";
	
	public static Connection getConnection(){
		Connection con = null;
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, usename, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static void close(Connection con,PreparedStatement ps){
		if(con!=null&&ps!=null){
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
