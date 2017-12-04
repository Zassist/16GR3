package com.qhit.t5.service.Impl;

import java.util.List;

import com.qhit.t5.bean.UserBean;
import com.qhit.t5.dao.UserDao;
import com.qhit.t5.dao.Impl.UserDaoImpl;
import com.qhit.t5.service.UserService;

public class UserServiceImpl implements UserService {
		private UserDao userDao = new UserDaoImpl();
	@Override
	
	public int addUser(UserBean userbean) throws Exception {
		// TODO Auto-generated method stub
		return userDao.addUser(userbean);
	}
	@Override
	public List<UserBean> getAllUser() throws Exception {
		// TODO Auto-generated method stub
		return userDao.getAllUser();
	}
	@Override
	public int delUser(int id) throws Exception {
		// TODO Auto-generated method stub
		return userDao.delUser(id);
	}
	@Override
	public UserBean getUserbyId(int id) {
		// TODO Auto-generated method stub
		return userDao.getUserbyId(id);
	}

}
