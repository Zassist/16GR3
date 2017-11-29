package com.qhit.hzz.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ��ݿ⹤����
 * @author �ֺ�һ
 *
 */
public class DBUtils {
	/**
	 * ��������
	 * @return
	 */
	public static Connection getCon(){
		String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=t_test";
		String username = "sa";
		String password = "123456";
		Connection con = null;
		try {
			Class.forName(driverClass);
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
		
	}
	/**
	 * �ر�����
	 * @param con
	 */
	public static void closeCon(Connection con){
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	public static void main(String[] args) {
		System.out.println(DBUtils.getCon());
	}
}
