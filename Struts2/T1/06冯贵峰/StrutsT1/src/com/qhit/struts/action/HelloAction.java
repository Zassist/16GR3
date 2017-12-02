package com.qhit.struts.action;

import com.opensymphony.xwork2.Action;

public class HelloAction implements Action {
	private String content;
	private String uname;

	@Override
	public String execute() throws Exception {
		content = "ÄãºÃ£¬"+uname;
		return SUCCESS;
	}


	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

}
