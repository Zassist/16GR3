package com.hm.t5.dao;

import java.util.List;

import com.hm.t5.bean.User;

public interface UserDao {
	public List<User> getAllUser() throws Exception;
	public int addUser(User user) throws Exception;
	public User getUserById(int id) throws Exception;
	public int updateUser(User user) throws Exception;
	public int deleteUser(int id) throws Exception;
}
