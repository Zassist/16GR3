package com.asa.T5.service;

import java.sql.SQLException;
import java.util.List;

import com.asa.T5.bean.User;

public interface UserService {
	/**
	 * @param user
	 * @return
	 * 添加
	 * @throws SQLException 
	 * @throws Exception 
	 */
	public int addUser(User user) throws SQLException ;
	
	/**
	 * @param user
	 * @return
	 * 删除
	 * @throws SQLException 
	 * @throws Exception 
	 */
	public int deleteUser(User user) throws SQLException ;
	
	
	/**
	 * @param user
	 * @return
	 * 修改
	 * @throws SQLException 
	 * @throws Exception 
	 */
	public int updateUser(User user) throws SQLException ;
	
	
	/**
	 * @param user
	 * @return
	 * 查
	 * @throws SQLException 
	 * @throws Exception 
	 */
	public List<User> getAllUser() throws SQLException ;
	
	
	/**
	 * @param user
	 * @return
	 * 根据id查用户
	 * @throws SQLException 
	 * @throws Exception 
	 */
	public User getUserById(User user) throws SQLException ;

}
