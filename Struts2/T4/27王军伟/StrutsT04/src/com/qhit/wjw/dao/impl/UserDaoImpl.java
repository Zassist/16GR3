package com.qhit.wjw.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qhit.wjw.bean.User;
import com.qhit.wjw.dao.UserDao;
import com.qhit.wjw.utils.DBManager;

public class UserDaoImpl implements UserDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public int addUser(User user) {
		con = DBManager.getConnection();
		String sql = "insert into tb_user values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPwd());
			ps.setInt(3, user.getSex());
			ps.setString(4, user.getEdu());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(ps, con);
		}
		return 0;
	}

	@Override
	public List<User> listUser() {
		con = DBManager.getConnection();
		List<User> users = new ArrayList<>();
		String sql = "select * from tb_user";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String pwd = rs.getString("pwd");
				int sex = rs.getInt("sex");
				String edus = rs.getString("edu");
				String[] edu = null;
				String[] strs = edus.split(",");
				for (int i = 0; i < strs.length-1; i++) {
					strs[i] = strs[i].toString();
				}
				users.add(new User(id, name, pwd, sex, edu));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(ps, con);
		}
		return users;
	}

}
