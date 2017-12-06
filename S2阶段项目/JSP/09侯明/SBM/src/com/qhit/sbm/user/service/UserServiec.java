package com.qhit.sbm.user.service;

import com.qhit.sbm.user.bean.User;

public interface UserServiec {
	/**
	 * @param userName
	 * @param userPassword
	 * @return
	 * 登录的业务
	 */
	public User doLogin(String userName,String userPassword);
	
	/**
	 * @param user
	 * @return
	 * 添加用户
	 */
	public int addUser(User user);
}
