package com.qhit.sbm.user.dao;

import com.qhit.sbm.user.bean.User;

public interface UserDao {
	/**
	 * @param userName
	 * @param userPassword
	 * @return
	 * 登录的数据访问
	 */
	public User doLogin(String userName,String userPassword);
	
	/**
	 * @param user
	 * @return
	 * 添加用户
	 */
	public int addUser(User user);
}
