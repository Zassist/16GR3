package com.grs.wjk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.grs.wjk.bean.User;
import com.grs.wjk.dao.UserDao;
import com.grs.wjk.utils.DBManager;

public class UserDaoImpl implements UserDao {
	private	Connection con;
	private PreparedStatement ps;
	
	@Override
	public int addUser(User user) {
		// TODO 添加
		con = DBManager.getConnection();
		String sql = "insert into t_user values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUname());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getSex());
			ps.setString(4, user.getEducation());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
