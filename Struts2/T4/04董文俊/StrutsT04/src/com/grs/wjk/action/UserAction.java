package com.grs.wjk.action;

import com.grs.wjk.bean.User;
import com.grs.wjk.service.UserService;
import com.grs.wjk.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.Action;

public class UserAction implements Action{
	private User user;
	private UserService us=new UserServiceImpl();
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		int count = us.addUser(user);
		if(count>0) {
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
