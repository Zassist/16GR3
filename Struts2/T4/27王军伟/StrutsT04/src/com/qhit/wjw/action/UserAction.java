package com.qhit.wjw.action;

import java.util.List;

import com.qhit.wjw.bean.User;
import com.qhit.wjw.service.impl.UserServiceImpl;

public class UserAction {
	private User user;
	private UserServiceImpl us = new UserServiceImpl();
	private List<User> userlist;

	public String useradd() throws Exception {
		int count = us.addUser(user);
		if (count > 0) {
			return userlist();
		} else {
			return "error";
		}
	}
	public String userlist() throws Exception {
		this.userlist = us.listUser();
		return "userlist";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserlist() {
		return userlist;
	}
}
