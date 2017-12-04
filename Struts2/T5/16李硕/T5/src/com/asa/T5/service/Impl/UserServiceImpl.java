package com.asa.T5.service.Impl;

import java.sql.SQLException;
import java.util.List;

import com.asa.T5.bean.User;
import com.asa.T5.dao.UserDao;
import com.asa.T5.dao.Impl.UserDaoImpl;
import com.asa.T5.service.UserService;

public class UserServiceImpl implements UserService {
	//声明一个全局的userdao对象
		private UserDao userDao = new UserDaoImpl(); 

	@Override
	public int addUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

	@Override
	public int deleteUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		return userDao.deleteUser(user);
	}

	@Override
	public int updateUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

	@Override
	public List<User> getAllUser() throws SQLException {
		// TODO Auto-generated method stub
		return userDao.getAllUser();
	}

	@Override
	public User getUserById(User user) throws SQLException {
		// TODO Auto-generated method stub
		return userDao.getUserById(user);
	}

}
