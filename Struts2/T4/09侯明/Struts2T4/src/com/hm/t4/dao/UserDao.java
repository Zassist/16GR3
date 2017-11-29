package com.hm.t4.dao;

import com.hm.t4.bean.User;

public interface UserDao {
	/**
	 * @param user
	 * @return
	 * 注册
	 */
	public int addUser(User user);
}
