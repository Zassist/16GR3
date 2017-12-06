package com.liuwei.sbm.user.dao;

import com.liuwei.sbm.user.bean.User;

public interface UserDao {
	
	public User doLogin(String userName,String passWord);
//	public User getUsers(User users); 
}
