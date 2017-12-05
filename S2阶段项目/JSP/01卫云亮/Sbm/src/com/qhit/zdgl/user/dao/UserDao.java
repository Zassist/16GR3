package com.qhit.zdgl.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.qhit.zdgl.common.bean.PageBean;
import com.qhit.zdgl.common.util.DBUtils;
import com.qhit.zdgl.user.bean.User;

/**
 * 用户DAO
 */
public class UserDao {
	/**
	 * 添加用户
	 */
	public int addUser(User user){
		String sql = "insert into tb_user(userName,userPassword,userSex,userAge,telephone,address,type) values(?,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		Connection con = DBUtils.getCon();
		int count = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserPassword());
			ps.setString(3, user.getUserSex());
			ps.setInt(4, user.getUserAge());
			ps.setString(5, user.getTelephone());
			ps.setString(6, user.getAddress());
			ps.setInt(7, user.getType());
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				ps.close();
				DBUtils.closeCon(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}
	/**
	 * 删除用户
	 */
	public int delUser(int userId){
		String sql = "delete from tb_user where userId = ?";
		PreparedStatement ps = null;
		Connection con = DBUtils.getCon();
		int count = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				ps.close();
				DBUtils.closeCon(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}
	/**
	 * 修改用户信息
	 */
	public int updUser(User user){
		String sql = "update tb_user set userName=?,userSex=?,userAge=?,telephone=?,address=?,type=?,pic=? where userId=?";
		PreparedStatement ps = null;
		Connection con = DBUtils.getCon();
		int count = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserSex());
			ps.setInt(3, user.getUserAge());
			ps.setString(4, user.getTelephone());
			ps.setString(5, user.getAddress());
			ps.setInt(6, user.getType());
			ps.setString(7, user.getPic());
			ps.setInt(8, user.getUserId());
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				ps.close();
				DBUtils.closeCon(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}
	/**
	 * 修改用户密码
	 */
	public int updUserPwd(Map map){
		return 0;
	}
	/**
	 * 查询所有
	 */
	public List<User> getAllUser(PageBean pb){
		int pageSize = pb.getPageSize();
		int p = pb.getP();
		String sql = "select top "+pageSize+" * from tb_user where userId not in (select top "+(p-1)*pageSize+" userId from tb_user)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = DBUtils.getCon();
		List<User> list = new ArrayList<User>(); 
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs!=null && rs.next()){
				int userId = rs.getInt("userId");
				String userName = rs.getString("userName");
				String userPassword = rs.getString("userPassword");
				String userSex = rs.getString("userSex");
				int userAge = rs.getInt("userAge");
				String telephone = rs.getString("telephone");
				String address = rs.getString("address");
				String pic = rs.getString("pic");
				int type = rs.getInt("type");
				User user = new User(userId, userName, userPassword, userSex, userAge, telephone, address, pic, type);
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				ps.close();
				DBUtils.closeCon(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	/**
	 * 登陆查询
	 */
	public User getUserForLogin(String userName,String userPassword){
		String sql = "select * from tb_user where userName = ? and userPassword = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = DBUtils.getCon();
		User user = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, userPassword);
			rs = ps.executeQuery();
			while(rs!=null && rs.next()){
				int userId = rs.getInt("userId");
				String userSex = rs.getString("userSex");
				int userAge = rs.getInt("userAge");
				String telephone = rs.getString("telephone");
				String address = rs.getString("address");
				String pic = rs.getString("pic");
				int type = rs.getInt("type");
				user = new User(userId, userName, userPassword, userSex, userAge, telephone, address, pic, type);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				ps.close();
				DBUtils.closeCon(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}
	/**
	 * 根据姓名模糊查询
	 */
	public List<User> getUserLikeName(String userName, PageBean pb){
		int pageSize = pb.getPageSize();
		int p = pb.getP();
		String sql = "select top "+pageSize+" * from tb_user" +
				" where userId not in (select top "+(p-1)*pageSize+" userId from tb_user where username like ?)" +
						" and userName like ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = DBUtils.getCon();
		List<User> list = new ArrayList<User>(); 
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+userName+"%");
			ps.setString(2, "%"+userName+"%");
			rs = ps.executeQuery();
			while(rs!=null && rs.next()){
				int userId = rs.getInt("userId");
				String r_userName = rs.getString("userName");
				String userPassword = rs.getString("userPassword");
				String userSex = rs.getString("userSex");
				int userAge = rs.getInt("userAge");
				String telephone = rs.getString("telephone");
				String address = rs.getString("address");
				String pic = rs.getString("pic");
				int type = rs.getInt("type");
				User user = new User(userId, r_userName, userPassword, userSex, userAge, telephone, address, pic, type);
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				ps.close();
				DBUtils.closeCon(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	/**
	 * 查询数据总条数
	 */
	public int getUserCount(String userName){
		String sql = "select count(*) sjts from tb_user";
		if(userName != null && !userName.equals("")){
			sql = sql + " where userName like ?";
		}
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = DBUtils.getCon();
		int count = 0;
		try {
			ps = con.prepareStatement(sql);
			if(userName != null && !userName.equals("")){
				ps.setString(1, "%"+userName+"%");
			}
			rs = ps.executeQuery();
			while(rs!=null && rs.next()){
				count = rs.getInt("sjts");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				ps.close();
				DBUtils.closeCon(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}
	public User getUserById(int userId){
		String sql = "select * from tb_user where userId = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = DBUtils.getCon();
		User user = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			while(rs!=null && rs.next()){
				String userName = rs.getString("userName");
				String userPassword = rs.getString("userPassword");
				String userSex = rs.getString("userSex");
				int userAge = rs.getInt("userAge");
				String telephone = rs.getString("telephone");
				String address = rs.getString("address");
				String pic = rs.getString("pic");
				int type = rs.getInt("type");
				user = new User(userId, userName, userPassword, userSex, userAge, telephone, address, pic, type);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				ps.close();
				DBUtils.closeCon(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}
}
