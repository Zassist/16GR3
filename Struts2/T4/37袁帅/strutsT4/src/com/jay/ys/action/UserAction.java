package com.jay.ys.action;


import com.jay.ys.bean.User;
import com.opensymphony.xwork2.Action;

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