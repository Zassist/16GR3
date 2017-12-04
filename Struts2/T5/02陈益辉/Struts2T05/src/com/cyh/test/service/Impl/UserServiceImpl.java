package com.cyh.test.service.Impl;

import java.util.List;

import com.cyh.test.Dao.UserDao;
import com.cyh.test.Dao.Impl.UserDaoImpl;
import com.cyh.test.bean.User;
import com.cyh.test.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao ud=new UserDaoImpl();
	public List<User> getAllUser() throws Exception {
		// TODO Auto-generated method stub
		return ud.getAllUser();
	}

	@Override
	public int addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return ud.addUser(user);
	}

	@Override
	public User getUserById(int id) throws Exception {
		// TODO Auto-generated method stub
		return ud.getUserById(id);
	}

	@Override
	public int updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return ud.updateUser(user);
	}

	@Override
	public int deleteUser(int id) throws Exception {
		// TODO Auto-generated method stub
		return ud.deleteUser(id);
	}

}
