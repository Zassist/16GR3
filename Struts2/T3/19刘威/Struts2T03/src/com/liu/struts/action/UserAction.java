package com.liu.struts.action;

import com.liu.struts.bean.User;
import com.opensymphony.xwork2.Action;

public class UserAction implements Action {
	private User user;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
