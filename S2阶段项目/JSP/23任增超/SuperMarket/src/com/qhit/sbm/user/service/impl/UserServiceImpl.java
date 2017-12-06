package com.qhit.sbm.user.service.impl;

import com.qhit.sbm.user.bean.User;
import com.qhit.sbm.user.dao.impl.UserDaoImpl;
import com.qhit.sbm.user.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public User doLogin(String userName,String userPassword) {
		// TODO 自动生成的方法存根
		return new UserDaoImpl().doLogin(userName, userPassword);
	}

}
