package com.kd.struts02.action;

import com.opensymphony.xwork2.Action;

public class LoginAction implements Action {
	private String name;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
