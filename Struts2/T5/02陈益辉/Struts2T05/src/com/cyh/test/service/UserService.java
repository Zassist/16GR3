package com.cyh.test.service;

import java.util.List;

import com.cyh.test.bean.User;

public interface UserService {
	public List<User> getAllUser() throws Exception;
	public int addUser(User user) throws Exception;
	public User getUserById(int id) throws Exception;
	public int updateUser(User user) throws Exception;
	public int deleteUser(int id) throws Exception;
}
