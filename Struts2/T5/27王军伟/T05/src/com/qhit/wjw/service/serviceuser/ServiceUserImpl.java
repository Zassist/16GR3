package com.qhit.wjw.service.serviceuser;

import java.util.List;

import com.qhit.wjw.bean.User;
import com.qhit.wjw.dao.impl.DaoUserImpl;
import com.qhit.wjw.service.ServiceUser;

public class ServiceUserImpl implements ServiceUser {

	@Override
	public int add(User user) throws Exception {
		return new DaoUserImpl().add(user);
	}

	@Override
	public int del(int id) throws Exception {
		return new DaoUserImpl().del(id);
	}

	@Override
	public int update(User user) throws Exception {
		return new DaoUserImpl().update(user);
	}

	@Override
	public List<User> sel() throws Exception {
		return new DaoUserImpl().sel();
	}

	@Override
	public User selUser(int id) throws Exception {
		return new DaoUserImpl().selUser(id);
	}

}
