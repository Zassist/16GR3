package com.liu.Struts.service;

import java.util.List;

import com.liu.Struts.bean.User;

public interface UserService {
	public List<User> getAll() throws Exception;
	public int add(User user) throws Exception;
	public int updateUser(User user) throws Exception;
	public int deleteUser(User user) throws Exception;
	public User getUserById(User user) throws Exception;
	}
