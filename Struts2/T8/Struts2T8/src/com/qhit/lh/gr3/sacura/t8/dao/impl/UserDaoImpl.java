/**
 * 
 */
package com.qhit.lh.gr3.sacura.t8.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qhit.lh.gr3.sacura.t8.bean.User;
import com.qhit.lh.gr3.sacura.t8.dao.UserDao;
import com.qhit.lh.gr3.sacura.t8.utils.DBManager;

/**
 * @author 路明非
 * 2017年12月10日下午4:18:42
 * TODO操作数据库
 */
public class UserDaoImpl implements UserDao {
	private Connection con = null;
	private PreparedStatement ps = null;
	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.sacura.t8.dao.UserDao#doLogin(java.lang.String, java.lang.String)
	 */
	@Override
	public User doLogin(String userName, String userPassword) throws Exception {
		con = DBManager.getConnection();
		User user = null;
		ResultSet rs = null;
		String sql = "select * from tb_user where userName = ? and userPassword = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, userName);
		ps.setString(2, userPassword);
		rs = ps.executeQuery();
		if(rs.next()) {
			user = new User(
					rs.getInt("userId"),
					userName,
					userPassword, 
					rs.getString("userSex"), 
					rs.getInt("userAge"), 
					rs.getString("telephone"), 
					rs.getString("address"),
					rs.getString("pic"), 
					rs.getInt("type")
					);
		}
		DBManager.close(con, ps);
		return user;
	}
	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.sacura.t8.dao.UserDao#getAllUser()
	 */
	@Override
	public List<User> getAllUser() throws Exception {
		con = DBManager.getConnection();
		List<User> users = new ArrayList<>();
		User user = null;
		ResultSet rs = null;
		String sql = "select * from tb_user";
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			user = new User(
					rs.getInt("userId"),
					rs.getString("userName"), 
					rs.getString("userPassword"), 
					rs.getString("userSex"), 
					rs.getInt("userAge"), 
					rs.getString("telephone"), 
					rs.getString("address"),
					rs.getString("pic"), 
					rs.getInt("type")
					);
			users.add(user);
		}
		DBManager.close(con, ps);
		return users;
	}
	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.sacura.t8.dao.UserDao#addUser(com.qhit.lh.gr3.sacura.t8.bean.User)
	 */
	@Override
	public int addUser(User user) throws Exception {
		con = DBManager.getConnection();
		int row = 0;
		String sql = "insert into tb_user values (?,?,?,?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getUserPassword());
		ps.setString(3, user.getUserSex());
		ps.setInt(4, user.getUserAge());
		ps.setString(5, user.getTelephone());
		ps.setString(6, user.getAddress());
		ps.setString(7, user.getPic());
		ps.setInt(8, user.getType());
		row =  ps.executeUpdate();
		DBManager.close(con, ps);
		return row;
	}
	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.sacura.t8.dao.UserDao#deleteUser(com.qhit.lh.gr3.sacura.t8.bean.User)
	 */
	@Override
	public int deleteUser(User user) throws Exception {
		con = DBManager.getConnection();
		String sql = "delete from tb_user where userId = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, user.getUserId());
		int row = ps.executeUpdate();
		DBManager.close(con, ps);
		return row;
	}
	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.sacura.t8.dao.UserDao#toUpdateUser(com.qhit.lh.gr3.sacura.t8.bean.User)
	 */
	@Override
	public User toUpdateUser(User user) throws Exception {
		con = DBManager.getConnection();
		String sql = "select * from tb_user where userId = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, user.getUserId());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			user = new User(
					rs.getInt("userId"),
					rs.getString("userName"), 
					rs.getString("userPassword"), 
					rs.getString("userSex"), 
					rs.getInt("userAge"), 
					rs.getString("telephone"), 
					rs.getString("address"),
					rs.getString("pic"), 
					rs.getInt("type")
					);
		}
		DBManager.close(con, ps);
		return user;
	}
	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.sacura.t8.dao.UserDao#UpdateUser(com.qhit.lh.gr3.sacura.t8.bean.User)
	 */
	@Override
	public int updateUser(User user) throws Exception {
		con = DBManager.getConnection();
		int row = 0;
		String sql = "update tb_user set userName = ?, userPassword = ?, userSex = ?,"
				+ "userAge = ?, telephone = ?, address = ?, pic = ?, type = ?"
				+ " where userId = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getUserPassword());
		ps.setString(3, user.getUserSex());
		ps.setInt(4, user.getUserAge());
		ps.setString(5, user.getTelephone());
		ps.setString(6, user.getAddress());
		ps.setString(7, user.getPic());
		ps.setInt(8, user.getType());
		ps.setInt(9, user.getUserId());
		row =  ps.executeUpdate();
		DBManager.close(con, ps);
		return row;
	}
	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.sacura.t8.dao.UserDao#getUser(com.qhit.lh.gr3.sacura.t8.bean.User)
	 */
	@Override
	public List<User> getUser(User user) throws Exception {
		con = DBManager.getConnection();
		List<User> users = new ArrayList<>();
		String sql = "select * from tb_user where userName = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, user.getUserName());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			user = new User(
					rs.getInt("userId"),
					rs.getString("userName"), 
					rs.getString("userPassword"), 
					rs.getString("userSex"), 
					rs.getInt("userAge"), 
					rs.getString("telephone"), 
					rs.getString("address"),
					rs.getString("pic"), 
					rs.getInt("type")
					);
			users.add(user);
		}
		DBManager.close(con, ps);
		return users;
	}

}
