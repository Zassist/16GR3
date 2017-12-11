/**
 * 
 */
package com.qhit.lh.gr3.sacura.t8.service.impl;

import java.util.List;

import com.qhit.lh.gr3.sacura.t8.bean.User;
import com.qhit.lh.gr3.sacura.t8.dao.UserDao;
import com.qhit.lh.gr3.sacura.t8.dao.impl.UserDaoImpl;
import com.qhit.lh.gr3.sacura.t8.service.UserService;

/**
 * @author 路明非
 * 2017年12月10日下午4:19:31
 * TODO业务接口类
 */
public class UserServiveImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();
	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.sacura.t8.service.UserServive#doLogin(java.lang.String, java.lang.String)
	 */
	@Override
	public User doLogin(String userName, String userPassword) throws Exception {
		return userDao.doLogin(userName, userPassword);
	}
	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.sacura.t8.service.UserService#getAllUser()
	 */
	@Override
	public List<User> getAllUser() throws Exception {
		return userDao.getAllUser();
	}
	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.sacura.t8.service.UserService#addUser(com.qhit.lh.gr3.sacura.t8.bean.User)
	 */
	@Override
	public int addUser(User user) throws Exception {
		return userDao.addUser(user);
	}
	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.sacura.t8.service.UserService#deleteUser(com.qhit.lh.gr3.sacura.t8.bean.User)
	 */
	@Override
	public int deleteUser(User user) throws Exception {
		return userDao.deleteUser(user);
	}
	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.sacura.t8.service.UserService#toUpdateUser(com.qhit.lh.gr3.sacura.t8.bean.User)
	 */
	@Override
	public User toUpdateUser(User user) throws Exception {
		return userDao.toUpdateUser(user);
	}
	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.sacura.t8.service.UserService#UpdateUser(com.qhit.lh.gr3.sacura.t8.bean.User)
	 */
	@Override
	public int updateUser(User user) throws Exception {
		return userDao.updateUser(user);
	}
	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.sacura.t8.service.UserService#getUser(com.qhit.lh.gr3.sacura.t8.bean.User)
	 */
	@Override
	public List<User> getUser(User user) throws Exception {
		return userDao.getUser(user);
	}

}
