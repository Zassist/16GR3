package com.hm.t4.service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hm.t4.bean.User;
import com.hm.t4.service.UserService;
import com.hm.t4.utils.DBManager;

public class UserServiceImpl implements UserService {
	private Connection con;
	private PreparedStatement ps;
	
	@Override
	public int addUser(User user) {
		con = DBManager.getConnection();
		String sql = "insert into t_user values (?,?,?,?)";
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, user.getUname());
		ps.setString(2, user.getUpwd());
		ps.setString(3, user.getEducation());
		ps.setInt(4, user.getSex());
		return ps.executeUpdate();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return 0;
	}
}
