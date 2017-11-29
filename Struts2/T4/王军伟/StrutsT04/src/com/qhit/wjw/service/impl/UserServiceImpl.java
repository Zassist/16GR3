package com.qhit.wjw.service.impl;

import java.util.List;

import com.qhit.wjw.bean.User;
import com.qhit.wjw.dao.impl.UserDaoImpl;
import com.qhit.wjw.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public int addUser(User user) {
		return new UserDaoImpl().addUser(user);
	}

	@Override
	public List<User> listUser() {
		return new UserDaoImpl().listUser();
	}

}
