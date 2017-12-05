package com.jt.struts.action;

import com.jt.struts.bean.User;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private User user = new User();
	
	public String Login(){
		if(user.getUname().length()<6 || user.getUname().length()>16){
			super.addFieldError("user.uname", getText("user.lenth"));
			return "input";
		}
		return "LoginSuccess";
	}
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if("".equals(user.getUname())){
			super.addFieldError("user.uname", getText("uname.empty"));
		}
		if("".equals(user.getUpwd())){
			super.addFieldError("user.upwd", getText("upwd.empty"));
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
