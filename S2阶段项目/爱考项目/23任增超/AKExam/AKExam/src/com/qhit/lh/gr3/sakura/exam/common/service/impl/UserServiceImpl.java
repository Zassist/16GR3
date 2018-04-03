/**
 * 
 */
package com.qhit.lh.gr3.sakura.exam.common.service.impl;


import com.qhit.lh.gr3.sakura.exam.common.bean.User;
import com.qhit.lh.gr3.sakura.exam.common.dao.UserDao;
import com.qhit.lh.gr3.sakura.exam.common.dao.UserDaoImpl;
import com.qhit.lh.gr3.sakura.exam.common.service.UserService;

/**
 * @author Administrator
 * TODO 登录业务接口的实现类
 * 2018-1-2下午7:40:54
 */
public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();
	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.sakura.exam.common.service.UserService#login(com.qhit.lh.gr3.sakura.exam.common.bean.User)
	 */
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}


}
