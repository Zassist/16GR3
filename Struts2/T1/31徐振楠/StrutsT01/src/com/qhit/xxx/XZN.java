package com.qhit.xxx;

import com.opensymphony.xwork2.Action;

public class XZN implements Action {
private String name;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		return "abc";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
