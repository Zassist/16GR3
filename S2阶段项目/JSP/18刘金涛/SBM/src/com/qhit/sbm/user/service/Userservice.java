package com.qhit.sbm.user.service;

import com.qhit.sbm.user.bean.User;

public interface Userservice {
	public User doLogin(String userName, String userPassword);

}
