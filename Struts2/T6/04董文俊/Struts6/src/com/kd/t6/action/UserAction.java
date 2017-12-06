package com.kd.t6.action;

import com.kd.t6.baen.User;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction  extends ActionSupport{
	private User user = new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String Login(){
		if(user.getUname().length()<6 || user.getUname().length()>16){
			super.addFieldError("user.uname", getText("uname.lenth"));
			return "input";
		}
		return "LoginSuccess";
	}
	@Override
	public void validate(){
		if(user.getUname().equals("")){
			super.addFieldError("user.uname", getText("uname.empty"));
		}
		if(user.getPwd().equals("")){
			super.addFieldError("user.pwd", getText("pwd.empty"));
		}
	}
}
