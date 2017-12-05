package com.cyh.test.Dao;

import java.awt.List;

import javax.jws.soap.SOAPBinding.Use;

public interface UserDao {
	public List getAllUser() throws Exception;

	public int addUser(Use user) throws Exception;

	public UserDao getUserById(int id) throws Exception;

	public int updateUser(Use user) throws Exception;

	public int deleteUser(int id) throws Exception;

}
