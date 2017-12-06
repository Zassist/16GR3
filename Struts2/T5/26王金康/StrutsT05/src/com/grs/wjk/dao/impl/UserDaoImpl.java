package com.grs.wjk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.grs.wjk.bean.User;
import com.grs.wjk.dao.UserDao;
import com.grs.wjk.utils.DBManager;

public class UserDaoImpl implements UserDao {
	private Connection con;
	private PreparedStatement ps;
	@Override
	public int add(User user) throws Exception {
		// TODO 添加
		con = DBManager.getConnection();
		String sql = "insert into tb_user values (?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, user.getUname());
		ps.setString(2, user.getUpwd());
		ps.setString(3, user.getSex());
		ps.setString(4, user.getBirthday());
		ps.setInt(5, user.getEnable());
		int row = ps.executeUpdate();
		DBManager.close(ps, con);
		return row;
	}

	@Override
	public int del(User user) throws Exception {
		// TODO 删除
		con = DBManager.getConnection();
		String sql = "delete from tb_user where uid = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, user.getUid());
		int row = ps.executeUpdate();
		DBManager.close(ps, con);
		return row;
	}

	@Override
	public int upd(User user) throws Exception {
		// TODO 更新
		con = DBManager.getConnection();
		String sql = "update tb_user set uname = ?, upwd = ?, sex = ?, birthday = ?, enable = ? where uid = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, user.getUname());
		ps.setString(2, user.getUpwd());
		ps.setString(3, user.getSex());
		ps.setString(4, user.getBirthday());
		ps.setInt(5, user.getEnable());
		ps.setInt(6, user.getUid());
		int row = ps.executeUpdate();
		DBManager.close(ps, con);
		return row;
	}

	@Override
	public List<User> getAll() throws Exception {
		// TODO 查询所有
		User user = null;
		List<User> users = new ArrayList<>();
		con = DBManager.getConnection();
		String sql = "select * from tb_user";
		ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			user = new  User(
					rs.getInt("uid"), 
					rs.getString("uname"), 
					rs.getString("upwd"), 
					rs.getString("sex"), 
					rs.getString("birthday"), 
					rs.getInt("enable"));
			users.add(user);
		}
		DBManager.close(ps, con);
		return users;
	}

	@Override
	public User getAllById(User user) throws Exception {
		// TODO 根据ID查询
		con = DBManager.getConnection();
		String sql = "select * from tb_user where uid = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, user.getUid());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			user = new User(
					rs.getInt("uid"), 
					rs.getString("uname"), 
					rs.getString("upwd"), 
					rs.getString("sex"), 
					rs.getString("birthday"), 
					rs.getInt("enable"));
		}
		DBManager.close(ps, con);
		return user;
	}
}
