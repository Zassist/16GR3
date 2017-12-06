package com.grs.wjk.service.impl;

import java.util.List;

import com.grs.wjk.bean.User;
import com.grs.wjk.dao.UserDao;
import com.grs.wjk.dao.impl.UserDaoImpl;
import com.grs.wjk.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();
	/* (non-Javadoc)
	 * @see com.grs.wjk.service.UserService#add(com.grs.wjk.bean.User)
	 */
	@Override
	public int add(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.add(user);
	}

	/* (non-Javadoc)
	 * @see com.grs.wjk.service.UserService#del(com.grs.wjk.bean.User)
	 */
	@Override
	public int del(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.del(user);
	}

	/* (non-Javadoc)
	 * @see com.grs.wjk.service.UserService#upd(com.grs.wjk.bean.User)
	 */
	@Override
	public int upd(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.upd(user);
	}

	/* (non-Javadoc)
	 * @see com.grs.wjk.service.UserService#getAll()
	 */
	@Override
	public List<User> getAll() throws Exception {
		// TODO Auto-generated method stub
		return userDao.getAll();
	}

	/* (non-Javadoc)
	 * @see com.grs.wjk.service.UserService#getAllById(com.grs.wjk.bean.User)
	 */
	@Override
	public User getAllById(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.getAllById(user);
	}

}
