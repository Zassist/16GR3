package com.qhit.sbm.user.dao;

import com.qhit.sbm.user.bean.User;

public interface UserDao {
	public User doLogin(String userName, String userPassword);

}
