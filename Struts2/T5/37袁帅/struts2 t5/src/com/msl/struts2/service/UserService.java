package com.msl.struts2.service;

import java.util.List;

import com.msl.struts2.bean.User;

public interface UserService {
	/**
	 * @return
	 * @throws Exception 
	 * 获取所有用户
	 */
	public List<User> getAllUser() throws Exception;

	/**
	 * @return
	 * @throws Exception
	 * 添加用户业务
	 */
	public int addUser(User user) throws Exception;

	/**
	 * @return
	 * @throws Exception
	 * 删除业务
	 */
	public int deleteUser(User user) throws Exception;
	
	/**
	 * @return
	 * @throws Exception
	 * 准备删除业务
	 */
	public User toUpdateUser(User user) throws Exception;
	
	/**
	 * @return
	 * @throws Exception
	 * 删除业务
	 */
	public int UpdateUser(User user) throws Exception;
}