package com.qhit.sym.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.qhit.sym.bean.User;
import com.qhit.sym.dao.DaoUser;
import com.qhit.sym.util.DBManager;

public class DaoUserImpl implements DaoUser {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public int add(User user) throws Exception {
		int count;
		String sql = "insert tb_user values(?,?,?,?,?)";
		con = DBManager.getConnection();
		ps = con.prepareStatement(sql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getBirthday());
		ps.setString(4, user.getSex());
		ps.setInt(5, user.getActive());
		count = ps.executeUpdate();
		DBManager.close(con, ps);
		return count;
	}

	@Override
	public int del(int id) throws Exception {
		int count;
		String sql = "delete from tb_user where id = ?";
		con = DBManager.getConnection();
		ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		count = ps.executeUpdate();
		DBManager.close(con, ps);
		return count;
	}

	@Override
	public int update(User user) throws Exception {
		int count;
		String sql = "update tb_user set name = ? , password = ? , birthday = ? , sex = ? , active = ? where id = ?";
		con = DBManager.getConnection();
		ps = con.prepareStatement(sql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getBirthday());
		ps.setString(4, user.getSex());
		ps.setInt(5, user.getActive());
		ps.setInt(6, user.getId());
		count = ps.executeUpdate();
		DBManager.close(con, ps);
		return count;
	}

	@Override
	public List<User> sel() throws Exception {
		List<User> users = new ArrayList<>();
		String sql = "select * from tb_user";
		con = DBManager.getConnection();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		while (rs.next()) {
			users.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"),
					rs.getString("birthday"), rs.getString("sex"), rs.getInt("active")));
		}
		rs.close();
		DBManager.close(con, ps);
		return users;
	}

	@Override
	public User selUser(int id) throws Exception {
		User user = new User();
		String sql = "select * from tb_user where id = ?";
		con = DBManager.getConnection();
		ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		if (rs.next()) {
			user.setId(id);
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setBirthday(rs.getString("birthday"));
			user.setSex(rs.getString("sex"));
			user.setActive(rs.getInt("active"));
		}
		rs.close();
		DBManager.close(con, ps);
		return user;
	}

}
