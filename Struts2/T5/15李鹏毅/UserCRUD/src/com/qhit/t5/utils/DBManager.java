package com.qhit.t5.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	
	public static Connection getConnection() throws SQLException {
		Connection con =null;
		
		String driveName="com.microsoft.sqlserver.jdbc.SQLServerDriver";

		String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=userCRUD";

		String userName="sa";

		String userPwd="123456";
		try {
			Class.forName(driveName);
			con=DriverManager.getConnection(dbURL, userName, userPwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;

	}
	
}


