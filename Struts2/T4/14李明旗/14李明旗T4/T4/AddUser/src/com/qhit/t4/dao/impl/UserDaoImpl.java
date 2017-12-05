package com.qhit.t4.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.qhit.t4.bean.UserBean;
import com.qhit.t4.dao.UserDao;
import com.qhit.t4.utils.DBManager;

public class UserDaoImpl implements UserDao {
		private Connection con;
		private PreparedStatement ps ;
	@Override
	public int AddUser(UserBean userbean) {
		
		String sql ="insert tb_user values (?,?,?,?,?)";
		try {
			con=DBManager.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1,userbean.getUname());
			ps.setString(2, userbean.getUpwd());
			ps.setString(3, userbean.getSex());
			ps.setString(4, userbean.getEdc());
			ps.setString(5,userbean.getTelephone());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
		return 0;
	}

}
