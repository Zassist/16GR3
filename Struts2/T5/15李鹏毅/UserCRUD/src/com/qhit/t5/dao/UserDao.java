package com.qhit.t5.dao;

import java.util.List;

import com.qhit.t5.bean.UserBean;

public interface UserDao {
	

	/**
	 * @param userbean
	 * @return
	 * @throws Exception
	 */
	public int addUser(UserBean userbean) throws Exception;
	
	/**
	 * @return
	 * @throws Exception
	 */
	public List<UserBean> getAllUser() throws Exception;
	
	public int delUser(int id) throws Exception;
	
	public UserBean getUserbyId(int id) throws Exception;
	public int updateUser(UserBean userbean) throws Exception;
}
