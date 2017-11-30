package com.jay.ren.service;

import com.jay.ren.bean.User;
import com.jay.ren.dao.UserDao;
import com.jay.ren.dao.UserDaoImpl;

public class UserServiceImpl implements UseService {
 
	@Override
	public int adduser(User user) {
	UserDao userdao=new UserDaoImpl();
	int i = userdao.adduser(user);
		// TODO Auto-generated method stub
		return i;
	}

}
