package com.qhit.wjw.service;

import java.util.List;

import com.qhit.wjw.bean.User;

public interface UserService {
	/**
	 * @param user
	 * @return 添加
	 */
	public int addUser(User user);

	/**
	 * @return 查询所有用户
	 */
	public List<User> listUser();
}
