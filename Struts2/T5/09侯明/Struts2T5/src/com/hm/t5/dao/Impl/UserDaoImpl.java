package com.hm.t5.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hm.t5.bean.User;
import com.hm.t5.dao.UserDao;
import com.hm.t5.utlis.DBManager;

public class UserDaoImpl implements UserDao{
	private static Connection con;
	private static PreparedStatement ps;
	
	public List<User> getAllUser() throws Exception{
		List<User> userlist = new ArrayList<User>();
		User user = null;
		con=DBManager.getConnection();
		String sql = "select * from t_user";
		ps = con.prepareStatement(sql);
		ResultSet rul = ps.executeQuery();
		while(rul.next()){
			user = new User(rul.getInt("uid"),
					rul.getString("uname"),
					rul.getString("upwd"),
					rul.getString("birthday"),
					rul.getString("sex"),
					rul.getInt("inEnable"));
			userlist.add(user);
		}
		return userlist;
	}

	@Override
	public int addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		String sql = "insert into t_user values (?,?,?,?,?)";
		ps=con.prepareStatement(sql);
		ps.setString(1, user.getUname());
		ps.setString(2, user.getUpwd());
		ps.setString(3, user.getBirthday());
		ps.setString(4, user.getSex());
		ps.setInt(5, user.getInEnable());
		return ps.executeUpdate();
	}

	@Override
	public User getUserById(int id) throws Exception {
		// TODO Auto-generated method stub
		User user = null;
		con = DBManager.getConnection();
		String sql = "select * from t_user where uid = ?";
		ps = con .prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rul = ps.executeQuery();
		if(rul.next()){
			user = new User(rul.getInt("uid"),
					rul.getString("uname"),
					rul.getString("upwd"),
					rul.getString("birthday"),
					rul.getString("sex"),
					rul.getInt("inEnable"));
		}
		return user;
	}

	@Override
	public int updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		con=DBManager.getConnection();
		String sql="update t_user set uname=?, upwd=?, birthday=?, sex=?, inEnable=? where id=?";
		ps=con.prepareStatement(sql);
		ps.setString(1, user.getUname());
		ps.setString(2, user.getUpwd());
		ps.setString(3, user.getBirthday());
		ps.setString(4, user.getSex());
		ps.setInt(5, user.getInEnable());
		ps.setInt(6, user.getUid());
		return ps.executeUpdate();
	}

	@Override
	public int deleteUser(int id) throws Exception {
		// TODO Auto-generated method stub
		con=DBManager.getConnection();
		System.out.println("DaoId:"+id);
		String sql="delete from t_user where id=?";
		ps=con.prepareStatement(sql);
		ps.setInt(1, id);
		return ps.executeUpdate();
	}
	
	
}