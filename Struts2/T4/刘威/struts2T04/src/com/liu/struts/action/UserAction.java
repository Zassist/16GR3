package com.liu.struts.action;

import com.liu.struts.bean.User;
import com.liu.struts.service.UserService;
import com.liu.struts.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.Action;

public class UserAction implements Action {
	private User user;
	private UserService uservice = new UserServiceImpl();
	@Override
	public String execute() throws Exception {
		int count = uservice.add(user);
		if(count>0){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
}
