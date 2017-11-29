package com.jay.t04.action;

import com.jay.t04.bean.User;
import com.jay.t04.service.UserService;
import com.jay.t04.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.Action;

public class UserAction implements Action {
     private User user;
     private UserService uService = new UserServiceImpl();
     
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String execute() throws Exception {
		// TODO 注册
		int row = uService.addUser(user);
		if(row > 0){
			return SUCCESS;
		}else{
			return ERROR;
		}
		
	}
  
}
