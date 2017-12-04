package com.liu.struts.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.liu.struts.bean.User;
import com.liu.struts.dao.UserDao;
import com.liu.struts.untils.DBManager;

public class UserDaoImpl implements UserDao {
	private Connection con;
	private PreparedStatement ps;
	@Override
	public int add(User user) {
		con = DBManager.getConnection();
		String sql= " insert into td_user values ( ? , ? , ? , ? , ? ) ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,user.getUname());
			ps.setString(2, user.getPwd());
			ps.setInt(3, user.getSex());
			ps.setString(4, user.getEducation());
			ps.setString(5, user.getTelphone());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
}
