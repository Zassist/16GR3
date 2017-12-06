package com.qhit.sbm.user.service.impl;

import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.user.bean.User;
import com.qhit.sbm.user.dao.impl.UserDaoImpl;
import com.qhit.sbm.user.service.UserService;

public class UserServiceImpl implements UserService {
	public User doLogin(String userName,String userPassword){
		
		return new UserDaoImpl().doLogin(userName, userPassword);
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().addUser(user);
	}

	@Override
	public PageBean getPageBean(PageBean pageBean) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().getPageBean(pageBean);
	}

	@Override
	public int delUser(int userId) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().delUser(userId);
	}
}
