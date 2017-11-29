package com.alin.action;

import com.alin.bean.User;
import com.opensymphony.xwork2.Action;

public class UseAction implements Action {
	private User user;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

	
	
}
