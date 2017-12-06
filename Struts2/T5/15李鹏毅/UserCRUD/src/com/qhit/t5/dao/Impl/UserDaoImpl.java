package com.qhit.t5.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qhit.t5.bean.UserBean;
import com.qhit.t5.dao.UserDao;
import com.qhit.t5.utils.DBManager;

public class UserDaoImpl implements UserDao {
		private Connection con;
		private PreparedStatement ps;
		
	@Override
	public int addUser(UserBean userbean) throws Exception {
		String sql ="insert t_user values (?,?,?,?,?)";
		
		con = DBManager.getConnection();
		ps=con.prepareStatement(sql);
		ps.setString(1, userbean.getUname());
		ps.setString(2, userbean.getUpwd());
		ps.setString(3, userbean.getSex());
		ps.setString(4, userbean.getBirthday());
		ps.setInt(5, userbean.getEnable());
		return ps.executeUpdate();
	}
	public  List<UserBean> getAllUser() throws Exception{
		UserBean userbean = null;
		List<UserBean> list = new ArrayList<UserBean>();
		String sql = "select * from t_user";
		
		con=DBManager.getConnection();
		ps=con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			userbean  = new UserBean(
					rs.getInt("id"), 
					rs.getString("uname"), 
					rs.getString("upwd"), 
					rs.getString("sex"), 
					rs.getString("birthday"), 
					rs.getInt("enable"));
			list.add(userbean);
		}
		return list;
	}
	@Override
	public int delUser(int id) throws Exception {
		String sql ="delete from t_user where id=?";
		con = DBManager.getConnection();
		ps=con.prepareStatement(sql);
		ps.setInt(1, id);
		return ps.executeUpdate();
	}
	
	
	@Override
	public UserBean getUserbyId(int id) throws Exception {
		UserBean userbean = null;
		String sql = "select * from t_user where id=?";
		con=DBManager.getConnection();
		ps=con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			userbean  = new UserBean(
					rs.getInt("id"), 
					rs.getString("uname"), 
					rs.getString("upwd"), 
					rs.getString("sex"), 
					rs.getString("birthday"), 
					rs.getInt("enable"));
		}
		return userbean;
	}
	
	public int updateUser(UserBean userbean) throws Exception{
		String sql ="update t_user set uname=?,upwd=?,sex=?,birthday=?,enable=? where id=?";
		con = DBManager.getConnection();
		ps=con.prepareStatement(sql);
		ps.setString(1, userbean.getUname());
		ps.setString(2, userbean.getUpwd());
		ps.setString(3, userbean.getSex());
		ps.setString(4, userbean.getBirthday());
		ps.setInt(5, userbean.getEnable());
		ps.setInt(6, userbean.getId());
		return ps.executeUpdate();
		
	}
}
