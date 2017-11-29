package com.asa.t4.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.asa.t4.bean.User;
import com.asa.t4.dao.UserDao;
import com.asa.t4.utils.DBManager;

public class UserDaoImpl implements UserDao {
   private Connection con=null;
   private PreparedStatement ps;
	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		String[] love=user.getLove();
		String loves="";
		for(int i=0;i<love.length;i++){
			loves+=love[i];
		}
		con=DBManager.getConnection();
		String 	sql="insert into users values (?,?,?,?,?)";
		try {
			  ps=con.prepareStatement(sql);
			 ps.setString(1, user.getName());
			 ps.setString(2, user.getPassword());
			 ps.setInt(3,user.getSex());
			 ps.setString(4,user.getEducation());
			 ps.setString(5,loves);
			 return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	

}
