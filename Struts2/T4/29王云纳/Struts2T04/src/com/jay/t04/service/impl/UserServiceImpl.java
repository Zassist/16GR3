package com.jay.t04.service.impl;

import com.jay.t04.bean.User;
import com.jay.t04.dao.impl.UserDaoImpl;
import com.jay.t04.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().addUser(user);
	}

}
