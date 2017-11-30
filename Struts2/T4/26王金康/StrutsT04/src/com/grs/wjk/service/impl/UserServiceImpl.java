package com.grs.wjk.service.impl;

import com.grs.wjk.bean.User;
import com.grs.wjk.dao.impl.UserDaoImpl;
import com.grs.wjk.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().addUser(user);
	}
	
}
