package com.qhit.xzn.userAction;

import com.opensymphony.xwork2.Action;

import com.qhit.xzn.bean.User;

public class UserAction implements Action {
     private User user;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return "success";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
