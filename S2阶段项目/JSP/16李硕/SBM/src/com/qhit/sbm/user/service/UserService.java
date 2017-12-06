package com.qhit.sbm.user.service;

import com.qhit.sbm.user.bean.User;

public interface UserService {
	/**
	 * @param userName
	 * @param passWord
	 * @return
	 * 登录的业务
	 */
	public User doLogin(String userName, String userPassword);
}
