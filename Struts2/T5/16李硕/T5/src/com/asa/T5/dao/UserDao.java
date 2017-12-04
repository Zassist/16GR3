package com.asa.T5.dao;

import java.sql.SQLException;
import java.util.List;

import com.asa.T5.bean.User;

public interface UserDao {

	public	int addUser(User user) throws SQLException;

	public	int deleteUser(User user) throws SQLException;

	public	int updateUser(User user) throws SQLException;

	public	List<User> getAllUser() throws SQLException;

	public	User getUserById(User user) throws SQLException;

}
