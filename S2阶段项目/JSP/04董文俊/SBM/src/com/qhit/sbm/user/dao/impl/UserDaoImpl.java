package com.qhit.sbm.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qhit.sbm.account.bean.AccountDetail;
import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.user.bean.User;
import com.qhit.sbm.user.dao.UserDao;
import com.qhit.sbm.utils.DBManager;

public class UserDaoImpl implements UserDao {
	private Connection con=null;
	private PreparedStatement ps=null;
	@Override
	public User doLogin(String userName,String userPassword) {
		con = DBManager.getConnection();
		User user = null;
		String sql = "select * from tb_user where userName = ? and userPassword = ?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, userPassword);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
					user =new User(
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
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return user;
	}
	//删除
	public int delUser(int userId) {
		con = DBManager.getConnection();
		String sql = "delete from tb_user where userId = ?";
		try {
			ps =con.prepareStatement(sql);
			ps.setInt(1, userId);
			return ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return 0;
	}
	//添加方法
	@Override
	public int addUser(User user) {
		con = DBManager.getConnection();
		String sql = "insert into tb_user values (?,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserPassword());
			ps.setString(3, user.getUserSex());
			ps.setInt(4, user.getUserAge());
			ps.setString(5, user.getTelephone());
			ps.setString(6, user.getAddress());
			ps.setString(7, user.getPic());
			ps.setInt(8, user.getType());
			return ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return 0;
	}
	@Override
	public PageBean getPageBean(PageBean pageBean) {
		con = DBManager.getConnection();
		User user = null;
		String sql = "select top "
				+ pageBean.getPagesize()
				+ " * from tb_user u where u.userId not in (select top "
				+ pageBean.getPagesize()*(pageBean.getP() - 1)
				+ " s.userId from tb_user s )";

		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				user=new User(
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
				pageBean.addData(user);
				
			}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return pageBean;
	}

}
