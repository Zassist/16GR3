package com.qhit.grsb.service;

import java.util.List;

import com.qhit.grsb.bean.Employee;
import com.qhit.grsb.dao.IUserDao;
import com.qhit.grsb.dao.UserDaoImpl;

public class UserServiceDao implements IUserService {

	IUserDao userDao = new UserDaoImpl();
	
	@Override
	public List userList() {
		return userDao.userList();
	}

	@Override
	public int addUser(Employee emp) {
		return userDao.addUser(emp);
	}

	@Override
	public int updateUser(Employee emp) {
		return userDao.updateUser(emp);
	}

	@Override
	public Employee findUser(int eid) {
		return userDao.findUser(eid);
	}

	@Override
	public int deleteUser(int eid) {
		return userDao.deleteUser(eid);
	}

	
	
}
