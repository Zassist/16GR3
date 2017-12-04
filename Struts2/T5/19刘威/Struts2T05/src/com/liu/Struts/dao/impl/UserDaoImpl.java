package com.liu.Struts.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.liu.Struts.bean.User;
import com.liu.Struts.dao.UserDao;
import com.liu.Struts.untils.DBManager;

public class UserDaoImpl implements UserDao {
	private Connection con;
	private PreparedStatement ps;

	public List<User> getAll() throws Exception {
		List<User> list = new ArrayList<User>();
		User user = null;
		con = DBManager.getConnection();
		String sql = "select * from td_user";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				user = new User(rs.getInt("uid"),
						rs.getString("uname"), 
						rs.getString("pwd"),
						rs.getString("birthday"),
						rs.getString("sex"), 
						rs.getInt("enable"));
				list.add(user);
			}
		return list;
	}

	@Override
	public int add(User user) throws Exception {
		con = DBManager.getConnection();
		String sql = " insert into td_user values (?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, user.getUname());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getBirthday());
		ps.setString(4, user.getSex());
		ps.setInt(5, user.getEnable());
		int row = ps.executeUpdate();
		DBManager.close(ps, con);
		return row;
	}

	@Override
	public int updateUser(User user) throws Exception{
		con = DBManager.getConnection();
		String sql = "update td_user set uname = ?, pwd = ?, birthday = ?, sex = ?, enable = ? where uid = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, user.getUname());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getBirthday());
		ps.setString(4, user.getSex());
		ps.setInt(5, user.getEnable());
		ps.setInt(6, user.getUid());
		int row = ps.executeUpdate();
		System.out.println("row"+row);
		DBManager.close(ps, con);
		return row;
	}

	@Override
	public int deleteUser(User user) throws Exception{
		con = DBManager.getConnection();
		String sql = "delete from td_user where uid = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, user.getUid());
		int row = ps.executeUpdate();
		DBManager.close(ps, con);
		return row;
	}

	@Override
	public User getUserById(User user) throws Exception {
		con = DBManager.getConnection();
		String sql = "select * from td_user where uid = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, user.getUid());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			user = new User(
					rs.getInt("uid"), 
					rs.getString("uname"), 
					rs.getString("pwd"), 
					rs.getString("birthday"), 
					rs.getString("sex"), 
					rs.getInt("enable"));
		}
		System.out.println("Byid"+user);
		DBManager.close(ps, con);
		return user;
	}
}
