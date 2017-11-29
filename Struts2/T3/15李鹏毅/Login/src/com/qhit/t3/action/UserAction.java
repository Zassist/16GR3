package com.qhit.t3.action;


import com.opensymphony.xwork2.Action;
import com.qhit.t3.bean.UserBean;

public class UserAction implements Action {
	private UserBean userbean;
	
	@Override
	public String execute() throws Exception {
		
		return Action.SUCCESS;
	}

	public UserBean getUserbean() {
		return userbean;
	}

	public void setUserbean(UserBean userbean) {
		this.userbean = userbean;
	}
	
}
