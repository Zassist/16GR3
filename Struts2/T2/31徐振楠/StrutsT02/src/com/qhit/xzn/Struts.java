package com.qhit.xzn;

import com.opensymphony.xwork2.Action;

public class Struts implements Action {
 private String name;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return "success";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
