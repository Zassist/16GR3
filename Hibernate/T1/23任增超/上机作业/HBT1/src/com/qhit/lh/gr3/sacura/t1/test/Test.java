package com.qhit.lh.gr3.sacura.t1.test;


import com.qhit.lh.gr3.sacura.t1.bean.User;
import com.qhit.lh.gr3.sacura.t1.service.BaseService;
import com.qhit.lh.gr3.sacura.t1.service.impl.BaseServiceImpl;

public class Test {
	private BaseService baseService = new BaseServiceImpl();
	private User user;
	@org.junit.Test
	public void test() {
		user = new User();
		user.setUpwd("tom");
		user.setUpwd("123456");
		user.setSex("M");
		user.setAge(12);
		baseService.add(user);
	}
	@org.junit.Test
	public void test1() {
		user = new User();
		user.setId(1);
		baseService.del(user);
	}
	@org.junit.Test
	public void test2() {
		user = new User();
		user.setId(2);
		baseService.getAll("from t_user");
	}
}
