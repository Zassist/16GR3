/**
 * 
 */
package com.kd.t5.service.impl;

import java.util.List;

import com.kd.t5.bean.User;
import com.kd.t5.dao.UserDao;
import com.kd.t5.dao.impl.UserDaoImpl;
import com.kd.t5.service.UserService;



public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl(); 


	@Override
	public int addUser(User user) throws Exception {
		//添加
		return userDao.addUser(user);
	}


	@Override
	public int deleteUser(User user) throws Exception {
		//删除
		return userDao.deleteUser(user);
	}

	@Override
	public int updateUser(User user) throws Exception {
		// 更新
		return userDao.updateUser(user);
	}

	@Override
	public List<User> getAllUser() throws Exception {
		// 获取
		return userDao.getAllUser();
	}

	@Override
	public User getUserById(User user) throws Exception {
		// 根据ID获取
		return userDao.getUserById(user);
	}

}
