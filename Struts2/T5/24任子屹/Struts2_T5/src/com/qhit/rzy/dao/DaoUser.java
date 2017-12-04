package com.qhit.sym.dao;

import java.util.List;

import com.qhit.sym.bean.User;

public interface DaoUser {

	/**
	 * @param user
	 * @return 添加
	 * @throws Exception
	 */
	int add(User user) throws Exception;

	/**
	 * @param user
	 * @return 删除
	 * @throws Exception
	 */
	int del(int id) throws Exception;

	/**
	 * @param user
	 * @return 修改
	 * @throws Exception 
	 */
	int update(User user) throws Exception;

	/**
	 * @return 遍历查询
	 * @throws Exception 
	 */
	List<User> sel() throws Exception;

	/**
	 * @param user
	 * @return 单个查询
	 * @throws Exception 
	 */
	User selUser(int id) throws Exception;
}
