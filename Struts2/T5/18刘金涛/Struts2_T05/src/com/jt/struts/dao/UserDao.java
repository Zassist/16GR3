package com.jt.struts.dao;

import java.util.List;

import com.jt.struts.bean.User;

public interface UserDao {

	public int addUser(User user) throws Exception;

	public int deleteUser(User user) throws Exception;

	public int updateUser(User user) throws Exception;

	public List<User> getAllUser() throws Exception;

	public User getUserById(User user) throws Exception;


}
