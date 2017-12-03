package com.qhit.xzn.dao.Imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.qhit.xzn.bean.User;
import com.qhit.xzn.dao.UserDao;
import com.qhit.xzn.utils.DBManager;

public class UserDaoImp implements UserDao {
	private Connection con;
	private PreparedStatement ps;
	@Override
	public int addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		con=DBManager.getConnection();
		String sql = "insert into users values(?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUname());
			ps.setString(2, user.getUpwd());
			ps.setInt(3,user.getAge() );
			ps.setString(4, user.getSex());
			ps.setString(5, user.getEdu());
			ps.setString(6, user.getAddress());
			ps.setString(7, user.getTel());
			int row = ps.executeUpdate();
			DBManager.close(ps, con);
		
		return row;
	}
	@Override
	public List<User> allUser()throws Exception {
		// TODO Auto-generated method stub
		List<User> listUser = new ArrayList<User>();
		User u = null;
		con=DBManager.getConnection();
		String sql = "select * from users";
		     ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				u= new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setUpwd(rs.getString("upwd"));
				u.setAge(rs.getInt("age"));
				u.setSex(rs.getString("sex"));
				u.setEdu(rs.getString("edu"));
				u.setAddress(rs.getString("address"));
				u.setTel(rs.getString("tel")
						);
				listUser.add(u);}
			return listUser;
	}
	@Override
	public int updUser(User user) throws Exception {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		String sql = "update users set uname = ?, upwd = ?, age = ?, sex = ?, edu = ?, address=?, tel=? where uid = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, user.getUname());
		ps.setString(2, user.getUpwd());
		ps.setInt(3, user.getAge());
		ps.setString(4, user.getSex());
		ps.setString(5, user.getEdu());
		ps.setString(6, user.getAddress());
		ps.setString(7, user.getTel());
		ps.setInt(8, user.getUid());
		int row = ps.executeUpdate();
		DBManager.close(ps, con);
		return row;
	}
	@Override
	public int delUser(User user) throws Exception {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		String sql = "delete from users where uid = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, user.getUid());
		int row = ps.executeUpdate();
		DBManager.close(ps, con);
		return row;
	}
	public User getUserById(User user) throws Exception {
		con = DBManager.getConnection();
		String sql = "select * from users where uid = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, user.getUid());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			user = new User(
					rs.getInt("uid"),
					rs.getString("uname"), 
					rs.getString("upwd"),
					rs.getInt("age"),
					rs.getString("sex"),
					rs.getString("edu"),
					rs.getString("address"),
					rs.getString("tel"));
					}
		DBManager.close(ps, con);
		return user;
	}

}
