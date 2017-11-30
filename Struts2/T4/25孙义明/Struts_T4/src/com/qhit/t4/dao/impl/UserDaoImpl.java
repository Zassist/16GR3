package com.qhit.t4.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.qhit.t4.bean.User;
import com.qhit.t4.dao.UserDao;
import com.qhit.t4.util.DBManager;

public class UserDaoImpl implements UserDao {
	private Connection con = null;
	private PreparedStatement ps = null;
	private User user = null;
	public int AddUser(User user) {
		con = DBManager.getConnection();
		String sql = "insert into t_user values (?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUname());
			ps.setString(2, user.getUpwd());
			ps.setString(3, user.getXl());
			ps.setInt(4, user.getSex());
			ps.setString(5, user.getPhone());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
