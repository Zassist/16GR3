package com.sacura.users.service.impl;

import java.util.List;

import com.sacura.users.bean.User;
import com.sacura.users.dao.UserDao;
import com.sacura.users.dao.impl.UserDaoImpl;
import com.sacura.users.service.UserService;

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
		return userDao.toUpdateUser(user);
	}

	@Override
	public int UpdateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.UpdateUser(user);
	}

}
