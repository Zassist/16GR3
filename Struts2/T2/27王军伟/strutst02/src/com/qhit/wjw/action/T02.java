package com.qhit.wjw.action;

import com.opensymphony.xwork2.Action;

public class T02 implements Action {
private String uname;
	@Override
	public String execute() throws Exception {
		return Action.SUCCESS;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}

}
