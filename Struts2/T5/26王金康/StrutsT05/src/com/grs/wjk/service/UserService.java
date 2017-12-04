package com.grs.wjk.service;

import java.util.List;

import com.grs.wjk.bean.User;

public interface UserService {
	
	/**
	 * @return
	 * 增
	 * @throws Exception 
	 */
	public int add(User user) throws Exception;
	
	/**
	 * @return
	 * 删
	 * @throws Exception 
	 */
	public int del(User user) throws Exception;
	
	/**
	 * @return
	 * 改
	 * @throws Exception 
	 */
	public int upd(User user) throws Exception;
	
	/**
	 * @return
	 * 查询所有
	 * @throws Exception 
	 */
	public List<User> getAll() throws Exception;
	
	/**
	 * @return
	 * 根据ID查询
	 * @throws Exception 
	 */
	public User getAllById(User user) throws Exception;
	
}
