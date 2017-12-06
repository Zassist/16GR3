package com.merida.t5.service;

import java.util.List;

import com.merida.t5.bean.User;

public interface UserService {
	/**
	 * @param user
	 * @return
	 * ���
	 * @throws Exception 
	 */
	public int addUser(User user) throws Exception;	
	/**
	 * @param user
	 * @return
	 * ɾ��
	 * @throws Exception 
	 */
	public int deleteUser(User user) throws Exception;
	/**
	 * @param user
	 * @return
	 * �޸�
	 * @throws Exception 
	 */
	public int updateUser(User user) throws Exception;
	
	
	/**
	 * @param user
	 * @return
	 * ��
	 * @throws Exception 
	 */
	public List<User> getAllUser() throws Exception;
	
	
	/**
	 * @param user
	 * @return
	 * ����id���û�
	 * @throws Exception 
	 */
	public User getUserById(User user) throws Exception;
}
