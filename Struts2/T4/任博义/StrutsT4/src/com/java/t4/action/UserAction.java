package com.java.t4.action;

import com.java.t4.bean.User;
import com.java.t4.service.UserService;
import com.java.t4.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.Action;

public class UserAction implements Action {
	private User user;
	private UserService uService = new UserServiceImpl();

	@Override
	public String execute() throws Exception {
		// TODO 注册
		int row = uService.addUser(user);
		if(row > 0){
			return Action.SUCCESS;
		}else{
			return Action.ERROR;
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
