package com.jay.t5.service;

import java.util.List;

import com.jay.t5.bean.User;

public interface UserService {
	/**
	 * ��
	 * @param user
	 * @return
	 */
	public int addUser(User user);
	/**
	 * ɾ��
	 * @param user
	 * @return
	 */
	public int deleteUser(User user);
	/**
	 * ��
	 * @param user
	 * @return
	 */
	public int updateUser(User user);
	
	public List<User> getAllUser();
	
	/**
	 * @param user
	 * @return
	 * ����id���û�
	 * @throws Exception 
	 */
	public User getUserById(User user) throws Exception;
	
}

	


