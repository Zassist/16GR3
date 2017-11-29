package com.hm.t4.action;

import com.hm.t4.bean.User;
import com.hm.t4.service.UserService;
import com.hm.t4.service.Impl.UserServiceImpl;
import com.opensymphony.xwork2.Action;

public class UserAction implements Action {
	private User user;
	private UserService uService = new UserServiceImpl();
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		int row = uService.addUser(user);
		if(row > 0) {
			return SUCCESS;
			}else {
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
