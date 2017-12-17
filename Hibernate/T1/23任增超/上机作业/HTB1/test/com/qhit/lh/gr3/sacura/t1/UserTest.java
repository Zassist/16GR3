package com.qhit.lh.gr3.sacura.t1;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.qhit.lh.gr3.sacura.t1.bean.User;
import com.qhit.lh.gr3.sacura.t1.service.BaseService;
import com.qhit.lh.gr3.sacura.t1.service.impl.BaseServiceImpl;

public class UserTest {
	private BaseService bs = new BaseServiceImpl();
	private User user;
	@Test
	public void add() {
		user = new User();
		user.setUname("王军伟");
		user.setUpwd("123456");
		user.setAge(35);
		user.setSex("M");
		bs.add(user);
	}
	@Test
	public void del() {
		user = new User();
		user.setId(2);
		bs.del(user);
	}
	@Test
	public void sel() {
		List<Object> list = bs.getAll("from User");
		for (Object object : list) {
			System.out.println(object);
		}
	}
	@Test
	public void upd() {
		user = new User();
		user.setId(1);
		user.setUname("666");
		user.setUpwd("123456");
		user.setAge(35);
		user.setSex("M");
		bs.upd(user);
	}
	

}
