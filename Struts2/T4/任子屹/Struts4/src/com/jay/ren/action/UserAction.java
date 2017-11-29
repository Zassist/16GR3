package com.jay.ren.action;

import com.jay.ren.bean.User;
import com.jay.ren.service.UseService;
import com.jay.ren.service.UserServiceImpl;
import com.opensymphony.xwork2.Action;

public class UserAction implements Action {
  private User user;
 private UseService us = new UserServiceImpl();
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub 注册
		int i = us.adduser(user);
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
