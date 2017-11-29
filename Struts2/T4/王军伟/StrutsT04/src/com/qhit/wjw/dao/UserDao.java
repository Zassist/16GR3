package com.qhit.wjw.dao;

import java.util.List;

import com.qhit.wjw.bean.User;

public interface UserDao {
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
