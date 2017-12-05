package util;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {

	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url="jdbc:sqlserver://localhost:1433;databaseName=chaoshi";
			con=DriverManager.getConnection(url,"sa","123456");
			System.out.println(con);
		}catch(Exception e){
			System.out.println(e);
		}
		return con;
	}
	//关闭连接
	public static void close(Connection con){
		try{
			con.close();
		}catch(Exception e){}
	}
	
	public static void main(String[] args){
		ConnectionFactory.getConnection();
		
	}
	
}
