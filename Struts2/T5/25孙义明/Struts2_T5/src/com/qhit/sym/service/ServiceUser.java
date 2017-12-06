package com.qhit.sym.service;

import java.util.List;

import com.qhit.sym.bean.User;

public interface ServiceUser {

	/**
	 * @param user
	 * @return 添加
	 * @throws Exception
	 */
	int add(User user) throws Exception;

	/**
	 * @param id
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
	 * @param id
	 * @return 单个查询
	 * @throws Exception
	 */
	User selUser(int id) throws Exception;
}
