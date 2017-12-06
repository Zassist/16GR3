package com.qhit.smb.User.service.Impl;

import com.qhit.smb.User.bean.User;
import com.qhit.smb.User.dao.Impl.UserDaoImpl;
import com.qhit.smb.User.service.UserService;
import com.qhit.smb.common.bean.PageBean;

/**
 * @author 作者 E-mail:
 * @version 创建时间：2017年11月13日 下午1:32:41 类说明
 */
public class UserServiceImpl implements UserService {

	/**
	 * 登陆认证
	 * 
	 * @param userName
	 * @param userPassword
	 * @return
	 */
	@Override
	public User Login(String userName, String userPassword) {
		return new UserDaoImpl().Login(userName, userPassword);
	}

	@Override
	public User register(User user) {
		return new UserDaoImpl().register(user);
	}

	@Override
	public PageBean GetAllUser(PageBean pageBean) {
		return new UserDaoImpl().GetAllUser(pageBean);
	}

	@Override
	public PageBean QueryUser(PageBean pageBean, String userName) {
		return new UserDaoImpl().QueryUser(pageBean, userName);
	}

}
