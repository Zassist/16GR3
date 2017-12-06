package com.qhit.hzz.service.impl;

import com.qhit.hzz.bean.User;
import com.qhit.hzz.dao.UserDaoImpl;
import com.qhit.hzz.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().addUser(user);
	}

}
