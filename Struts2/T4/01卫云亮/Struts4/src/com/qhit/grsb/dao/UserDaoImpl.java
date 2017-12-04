package com.qhit.grsb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.qhit.grsb.bean.User;
import com.qhit.grsb.utils.DBManger;

public class UserDaoImpl implements UserDao {
  private Connection con;
  private PreparedStatement ps;
	@Override
	public int adduser(User user) {
		// TODO Auto-generated method stub
		
		con=DBManger.getConnection();
		String sql="insert into t_use values (?,?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getSex());
			ps.setString(4, user.getNativeplace());
			ps.setString(5, user.getEducation());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
