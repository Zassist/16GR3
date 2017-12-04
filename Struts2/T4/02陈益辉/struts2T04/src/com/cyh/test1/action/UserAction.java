package com.cyh.test1.action;

import com.cyh.test1.bean.User;
import com.opensymphony.xwork2.Action;

public class UserAction implements Action {
	private User user;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(user.getTelephone());
		return SUCCESS ;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}