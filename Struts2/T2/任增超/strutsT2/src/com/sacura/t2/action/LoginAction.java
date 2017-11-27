package com.sacura.t2.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class LoginAction implements Action {
	private String uname;
	private String upwd;
	@Override
	public String execute() throws Exception {
		if( uname.equals("159396")&&upwd.equals("123456")){
			return Action.SUCCESS;
		}else{
			ServletActionContext.getRequest().setAttribute("errorMsg","用户名或密码错误");
			return Action.ERROR;
		}
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpdw() {
		return upwd;
	}
	public void setUpdw(String updw) {
		this.upwd = updw;
	}
}
