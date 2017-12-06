package com.qhit.sbm.user.service.Imp;

import com.qhit.sbm.user.bean.User;
import com.qhit.sbm.user.dao.Imp.UserDaoImp;
import com.qhit.sbm.user.service.UserService;

public class UserServiceImp implements UserService {

	@Override
	public User doLogin(String userName, String passWord) {
		// TODO Auto-generated method stub
		return new UserDaoImp().doLogin(userName, passWord);
	}

}
