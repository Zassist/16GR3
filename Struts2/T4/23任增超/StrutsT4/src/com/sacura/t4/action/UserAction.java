package com.sacura.t4.action;

import com.opensymphony.xwork2.Action;
import com.sacura.t4.bean.User;

public class UserAction implements Action {
	private User user;
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
