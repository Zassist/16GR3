package com.qhit.t4.action;

import com.opensymphony.xwork2.Action;
import com.qhit.t4.bean.User;
import com.qhit.t4.service.UserService;
import com.qhit.t4.service.impl.UserServiceImpl;

public class UserAction implements Action {
	private User user;
	UserService usersc = new UserServiceImpl();

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub 注册
		int i =usersc.AddUser(user);
		if(i>0){
			return SUCCESS;
		}
		else {
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
