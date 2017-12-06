package com.asa.t4.service.Impl;

import com.asa.t4.bean.User;
import com.asa.t4.dao.Impl.UserDaoImpl;
import com.asa.t4.service.UserService;

public class UserServiceImpl implements UserService {

	

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().addUser(user) ;
	}

}
