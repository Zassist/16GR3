package com.qhit.sbm.user.dao;

import com.qhit.sbm.user.bean.User;

public interface UserDao {
	/**
	 * @param userName
	 * @param userPassWord
	 * @return
	 * 登录数据访问
	 */
	public User doLogin(String userName,String userPassword);
}
