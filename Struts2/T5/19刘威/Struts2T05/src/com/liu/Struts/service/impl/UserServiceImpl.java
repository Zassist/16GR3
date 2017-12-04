package com.liu.Struts.service.impl;

import java.util.List;

import com.liu.Struts.bean.User;
import com.liu.Struts.dao.UserDao;
import com.liu.Struts.dao.impl.UserDaoImpl;
import com.liu.Struts.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userdao = new UserDaoImpl();
	@Override
	public List<User> getAll() throws Exception {
		// TODO Auto-generated method stub
		return userdao.getAll();
	}
	@Override
	public int add(User user) throws Exception {
		// TODO Auto-generated method stub
		return userdao.add(user);
	}
	@Override
	public int updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userdao.updateUser(user);
	}
	@Override
	public int deleteUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userdao.deleteUser(user);
	}
	@Override
	public User getUserById(User user) throws Exception {
		// TODO Auto-generated method stub
		return userdao.getUserById(user);
	}

}
