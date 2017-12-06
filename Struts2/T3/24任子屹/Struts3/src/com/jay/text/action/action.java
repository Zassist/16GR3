package com.jay.text.action;

import com.jay.text.bean.user;
import com.opensymphony.xwork2.Action;

public class action implements Action {
	private user user;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	
	public user getUser() {
		return user;
	}
	
	public void setUser(user user) {
		this.user = user;
	}
}
