package com.merida.t4.service.impl;

import com.merida.t4.bean.User;
import com.merida.t4.dao.impl.UserDaoImpl;
import com.merida.t4.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().addUser(user);
	}
      
}
