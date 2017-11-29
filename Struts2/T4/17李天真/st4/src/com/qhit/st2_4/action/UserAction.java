package com.qhit.st2_4.action;

import com.opensymphony.xwork2.Action;
import com.qhit.st2_4.bean.User;
import com.qhit.st2_4.dao.impl.UserDaoImpl;
import com.qhit.st2_4.service.UserService;
import com.qhit.st2_4.service.impl.UserServiceImpl;

public class UserAction implements Action {
	private User user;
	private UserService us=new UserServiceImpl();
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
	
	
	

	

}
