package com.jt.struts.service.impl;

import java.util.List;

import com.jt.struts.bean.User;
import com.jt.struts.dao.UserDao;
import com.jt.struts.dao.impl.UserDaoImpl;
import com.jt.struts.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();

	@Override
	public List<User> getAllUser() throws Exception {
		// TODO Auto-generated method stub
		return userDao.getAllUser();
	}

	@Override
	public int updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
		
	}

	@Override
	public User getUserById(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.getUserById(user);
	}

	@Override
	public int deleteUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.deleteUser(user);
		
	}

	@Override
	public int addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
		
		
	}

}
