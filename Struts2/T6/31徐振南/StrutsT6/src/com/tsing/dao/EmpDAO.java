package com.tsing.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tsing.db.DBConnection;
import com.tsing.vo.Employee;

public class EmpDAO {

	//查询所有
	public List findAllEmps(Employee employee) {
		String sql = "select e.*,d.dname from employee e , department d where e.did = d.did ";
		List list = new ArrayList();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConn();
			stm = conn.createStatement();
			if (employee != null) {
				if (employee.getEname() != null
						&& !"".equals(employee.getEname())) {
					sql += "   and e.ename like '%" + employee.getEname()
							+ "%' ";
				}
				if (employee.getJob() != null && !"".equals(employee.getJob())) {

					sql += "   and e.job like '%" + employee.getJob() + "%' ";
				}

				if (employee.getDid() != null && employee.getDid() != 0) {
					sql += "   and d.did=" + employee.getDid();

				}

			}

			System.out.println(sql);
			rs = stm.executeQuery(sql);
			while (rs != null && rs.next()) {
				Employee emp = new Employee();
				emp.setEid(rs.getInt("eid"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setSex(rs.getString("sex"));
				emp.setSal(rs.getFloat("sal"));
				emp.setDid(rs.getInt("did"));
				emp.setDname(rs.getString("dname"));
				list.add(emp);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			// 关闭

		}
		return list;

	}

	public List findAlldepts() {
		String sql = "select d.* from  department d ";
		List list = new ArrayList();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConn();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while (rs != null && rs.next()) {
				Employee emp = new Employee();
				emp.setDid(rs.getInt("did"));
				emp.setDname(rs.getString("dname"));
				list.add(emp);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			// 关闭

		}
		return list;

	}

	public Employee findEmpById(Integer eid) {
		String sql = "select e.*  from  employee e where e.eid=" + eid;
		List list = new ArrayList();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		Employee emp = new Employee();
		try {
			conn = DBConnection.getConn();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			if (rs != null && rs.next()) {
				emp.setEid(rs.getInt("eid"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setSal(rs.getFloat("sal"));
				emp.setSex(rs.getString("sex"));
				emp.setDid(rs.getInt("did"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			// 关闭

		}
		return emp;

	}

	public boolean addEmp(Employee employee) {
		Connection conn = null;
		String sql = "insert into employee values(null,?,?,?,?,?)";
		try {
			conn = DBConnection.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, employee.getEname());
			ps.setString(2, employee.getSex());
			ps.setString(3, employee.getJob());
			ps.setFloat(4, employee.getSal());
			ps.setInt(5, employee.getDid());
			return ps.executeUpdate() > 0 ? true : false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		return false;
	}

	public boolean updateEmp(Employee employee) {
		Connection conn = null;
		String sql = "update employee set ename=?,sex=?,job=?,sal=?,did=? where eid=?";
		try {
			conn = DBConnection.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, employee.getEname());
			ps.setString(2, employee.getSex());
			ps.setString(3, employee.getJob());
			ps.setFloat(4, employee.getSal());
			ps.setInt(5, employee.getDid());
			ps.setInt(6, employee.getEid());
			return ps.executeUpdate() > 0 ? true : false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		return false;
	}

	public boolean delEmp(Integer eid) {
		Connection conn = null;
		String sql = " delete from employee  where eid=?";
		try {
			conn = DBConnection.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, eid);
			return ps.executeUpdate() > 0 ? true : false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		return false;
	}

}
