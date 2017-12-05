package com.sacura.t6.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sacura.t6.bean.User;

/**
 * @author S01
 *
 */
public class UserAction extends ActionSupport {
	
	private User user;
	
	@Override
	public void validate() {
		if(user == null) {
			super.addFieldError("user.uname", "没有填写信息");
		}
		else
			{
			if (user.getUname() == "" && user.getUname() == null) {
			super.addFieldError("user.uname", getText("uname.empty"));
		}
		if (user.getUpwd() == "" && user.getUpwd() == null) {
			super.addFieldError("user.upwd", getText("upwd.empty"));
		}
			}
		super.validate();
	}
	public String execute() throws Exception {
		
		return "success";
	}



	public String Login() {
		return "loginSuccess";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
