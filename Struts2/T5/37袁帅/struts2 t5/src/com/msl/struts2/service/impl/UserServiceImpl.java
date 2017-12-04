package com.msl.struts2.service.impl;

import java.util.List;

import com.msl.struts2.bean.User;
import com.msl.struts2.dao.UserDao;
import com.msl.struts2.dao.impl.UserDaoImpl;
import com.msl.struts2.service.UserService;

public class UserServiceImpl implements UserService {
     
	private UserDao userDao = new UserDaoImpl();
	@Override
	public List<User> getAllUser() throws Exception {
		return userDao.getAllUser();
	}
	
	@Override
	public int addUser(User user) throws Exception {
		return userDao.addUser(user);
	}

	@Override
	public int deleteUser(User user) throws Exception {
		return userDao.deleteUser(user);
	}

	@Override
	public User toUpdateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int UpdateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
