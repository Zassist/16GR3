package com.merida.t4.action;

import com.merida.t4.bean.User;
import com.merida.t4.service.UserService;
import com.merida.t4.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.Action;

public class UserAction {
    private User user;
    private UserService uService= new UserServiceImpl();
    
	public String execute() throws Exception {
		// TODO ×¢²á
		int row = uService.addUser(user);
		if (row > 0) {
			return "success";
		}else {
			return "error";
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
