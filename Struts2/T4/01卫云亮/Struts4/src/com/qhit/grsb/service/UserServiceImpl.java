package com.qhit.grsb.service;

import com.qhit.grsb.bean.User;
import com.qhit.grsb.dao.UserDao;
import com.qhit.grsb.dao.UserDaoImpl;

public class UserServiceImpl implements UseService {
 
	@Override
	public int adduser(User user) {
	UserDao userdao=new UserDaoImpl();
	int i = userdao.adduser(user);
		// TODO Auto-generated method stub
		return i;
	}

}
