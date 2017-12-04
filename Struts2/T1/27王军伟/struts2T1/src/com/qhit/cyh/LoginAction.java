package com.qhit.cyh;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class LoginAction implements Action {
	private String nam;
	private String pwd;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if (nam == "" || pwd == "" || nam == null || pwd == null) {
			ServletActionContext.getRequest().setAttribute("Info", "账号和密码不能为空！");
			return "shibai";
		}

		if (nam.equals("tom") && pwd.equals("123456")) {
			ServletActionContext.getRequest().setAttribute("haha", "欢迎你：");
			return "chengg";
		} else {
			ServletActionContext.getRequest().setAttribute("Info", "账号密码错误！");
			return "shibai";
		}
	}

	public String getNam() {
		return nam;
	}

	public void setNam(String nam) {
		this.nam = nam;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
