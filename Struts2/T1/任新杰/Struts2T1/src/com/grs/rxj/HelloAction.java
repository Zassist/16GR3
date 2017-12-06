package com.grs.rxj;

import com.opensymphony.xwork2.Action;

public class HelloAction implements Action {
	private String content;
	private String uname;
	
	public String getContent() {
		return content;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		content = "您好，"+uname;
		return Action.SUCCESS;
	}

}
