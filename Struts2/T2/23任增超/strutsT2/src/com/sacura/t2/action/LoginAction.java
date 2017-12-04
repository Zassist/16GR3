package com.sacura.t2.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class LoginAction implements Action {
	private String uname;
	private String upwd;

	@Override
	public String execute() throws Exception {
		if (uname.equals("tom") && upwd.endsWith("123456")) {
			return SUCCESS;
		} else {
			ServletActionContext.getRequest().getSession().setAttribute("error", "用户名或密码不正确");
			return Action.ERROR;
		}
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

}
