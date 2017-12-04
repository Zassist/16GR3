package com.liuwei.sbm.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.liuwei.sbm.untils.DBManager;
import com.liuwei.sbm.user.bean.User;
import com.liuwei.sbm.user.dao.UserDao;

public class UserDaoimpl implements UserDao {
	
	private Connection  con = null;
	private PreparedStatement ps = null;
	private User user = null;
	
	public User doLogin(String userName, String userPassword) {
		con = DBManager.getConnection();
		String sql = "select * from tb_user where userName = ? and userPassword = ?"; 
		try {
			ps  = con .prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, userPassword);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				user = new User(
						rs.getInt("userId"), 
						rs.getString("userName"), 
						rs.getString("userPassword"), 
						rs.getString("userSex"), 
						rs.getInt("userAge"), 
						rs.getString("telephone"), 
						rs.getString("address"), 
						rs.getString("pic"), 
						rs.getInt("type"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(ps, con);
		}
		return user;
	}
//	public User getUsers(User users) {
//		con = DBManager.getConnection();
//		String sql = " select * from tb_user ";
//		try {
//			ps = con.prepareStatement(sql);
//			ResultSet rs =  ps.executeQuery();
//			while(rs.next()){
//				user = new User(rs.getInt("userId"), 
//						rs.getString("userName"), 
//						rs.getString("userSex"), 
//						rs.getString("userAge"),
//						rs.getString("telephone"), 
//						rs.getString("address"), 
//						rs.getInt("type"));
//				
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
}
