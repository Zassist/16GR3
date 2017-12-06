package com.liu.Struts.dao;

import java.util.List;

import com.liu.Struts.bean.User;

public interface UserDao {
	public List<User> getAll() throws Exception;
	public int add(User user) throws Exception;
	public int updateUser(User user) throws Exception; 
	public int deleteUser(User user) throws Exception;
	public User getUserById(User user) throws Exception;
}
