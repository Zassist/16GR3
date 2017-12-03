package com.qhit.xzn.service.imp;

import java.sql.SQLException;
import java.util.List;

import com.qhit.xzn.bean.User;
import com.qhit.xzn.dao.UserDao;
import com.qhit.xzn.dao.Imp.UserDaoImp;
import com.qhit.xzn.service.UserService;

public class UserServiceImp implements UserService {
private UserDao Dao = new UserDaoImp();
	@Override
	public int addUser(User user) throws Exception {
		return new UserDaoImp().addUser(user);
	}

	@Override
	public List<User> allUser() throws Exception {
		// TODO Auto-generated method stub
		return Dao.allUser();
	}

	@Override
	public int updUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return Dao.updUser(user);
	}

	@Override
	public int delUser(User user) throws Exception {
		return Dao.delUser(user);
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUserById(User user) throws Exception {
		// TODO Auto-generated method stub
		return Dao.getUserById(user);
	}


}
