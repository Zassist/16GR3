package com.qhit.grsb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.qhit.grsb.bean.Employee;
import com.qhit.grsb.util.ConnectionFactory;

public class UserDaoImpl implements IUserDao {

	Connection conn = null ;
	
	
	
	public List userList() {
		
		List<Employee> list = new ArrayList<Employee>();
		conn = ConnectionFactory.getConnection();
		String sql = "select * from empp";
		try {
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery(sql);
			while(res!=null&&res.next()){
				Employee e = new Employee();
				e.setId(res.getInt(1));
				e.setName(res.getString(2));
				e.setPwd(res.getString(3));
				e.setBirth(res.getString(4));
				e.setSex(res.getString(5));
				e.setIsActive(res.getString(6));
				
				list.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}



	@Override
	public int addUser(Employee emp) {
		
		conn = ConnectionFactory.getConnection();
		String sql = "insert into empp values(?,?,?,?,?)";
		int flag = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getPwd());
			ps.setString(3, emp.getBirth());
			ps.setString(4, emp.getSex());
			ps.setString(5, emp.getIsActive());
			
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}



	@Override
	public int updateUser(Employee emp) {
		
		conn = ConnectionFactory.getConnection();
		String sql = "update empp set name=?,pwd=?,birth=?,sex=?,isActive=? where id=?";
		int flag = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getPwd());
			ps.setString(3, emp.getBirth());
			ps.setString(4, emp.getSex());
			ps.setString(5, emp.getIsActive());
			ps.setInt(6, emp.getId());
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}



	@Override
	public Employee findUser(int eid) {
		
		conn = ConnectionFactory.getConnection();
		String sql = "select * from empp where id="+eid;
		Employee e = new Employee();
		try {
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery(sql);
			while(res!=null&&res.next()){
				
				e.setId(res.getInt(1));
				e.setName(res.getString(2));
				e.setPwd(res.getString(3));
				e.setBirth(res.getString(4));
				e.setSex(res.getString(5));
				e.setIsActive(res.getString(6));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return e;
	}



	@Override
	public int deleteUser(int eid) {
		
		conn = ConnectionFactory.getConnection();
		String sql = "delete from empp where id="+eid;
		Employee e = new Employee();
		int flag = 0;
		try {
			Statement st = conn.createStatement();
			flag = st.executeUpdate(sql);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return flag;
	}

}
