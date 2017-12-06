package com.qhit.grsb.dao;

import java.util.List;

import com.qhit.grsb.bean.Employee;

public interface IUserDao {

	public List userList();
	
	public int addUser(Employee emp);
	
	public int updateUser(Employee emp);
	
	public Employee findUser(int eid);
	
	public int deleteUser(int eid);
	
	
}
