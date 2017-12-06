package com.liu.struts.service.impl;

import com.liu.struts.bean.User;
import com.liu.struts.dao.impl.UserDaoImpl;
import com.liu.struts.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public int add(User user) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().add(user);
	}

}
