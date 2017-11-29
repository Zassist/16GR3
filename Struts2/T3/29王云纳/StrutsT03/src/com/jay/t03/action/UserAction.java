package com.jay.t03.action;

import com.jay.t03.bean.User;
import com.opensymphony.xwork2.Action;

public class UserAction implements Action {
  private User user;
	public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

}
