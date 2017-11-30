package com.qhit.hzz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.qhit.hzz.bean.User;
import com.qhit.hzz.utils.DBUtils;

public class UserDaoImpl implements UserDao {
   private Connection con ;
   private PreparedStatement ps;
	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		con=DBUtils.getCon();
		String sql ="insert into t_user values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUname());
			ps.setString(2, user.getUpwd());
			ps.setString(3, user.getEdu());
			ps.setString(4, user.getSex());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}

}
