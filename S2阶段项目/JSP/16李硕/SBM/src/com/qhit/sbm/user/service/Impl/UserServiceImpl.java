package com.qhit.sbm.user.service.Impl;

import com.qhit.sbm.user.bean.User;
import com.qhit.sbm.user.dao.Impl.UserDaoImpl;
import com.qhit.sbm.user.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public User doLogin(String userName, String userPassword) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().doLogin(userName, userPassword);
	}

}
