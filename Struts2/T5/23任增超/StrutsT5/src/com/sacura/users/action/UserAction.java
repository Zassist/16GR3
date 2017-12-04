package com.sacura.users.action;

import java.util.List;

import com.sacura.users.bean.User;
import com.sacura.users.service.UserService;
import com.sacura.users.service.impl.UserServiceImpl;

public class UserAction {
	private User user;
	private List<User> list;
	private UserService userService = new UserServiceImpl();

	public String addUser() throws Exception {
		userService.addUser(user);
		return "success";
	}

	public String deleteUser() throws Exception {
		userService.deleteUser(user);
		return "success";
	}

	public String updateUser() throws Exception {
			userService.UpdateUser(user);		
		return "success";

	}

	public String toUpdateUser() throws Exception {
		user = userService.toUpdateUser(user);
		return "success";
	}

	public String getAllUser() {
		try {
			this.list = userService.getAllUser();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getList() {
		return list;
	}
}
