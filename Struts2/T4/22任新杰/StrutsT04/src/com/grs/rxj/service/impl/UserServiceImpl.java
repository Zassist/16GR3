package com.grs.rxj.service.impl;

import com.grs.rxj.bean.User;
import com.grs.rxj.dao.impl.UserDaoImpl;
import com.grs.rxj.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().addUser(user);
	}
	
}
