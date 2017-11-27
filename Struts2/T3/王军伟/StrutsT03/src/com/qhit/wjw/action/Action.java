package com.qhit.wjw.action;

import com.qhit.wjw.bean.User;

public class Action implements com.opensymphony.xwork2.Action {
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
