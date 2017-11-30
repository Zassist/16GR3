package com.grs.wjk;

import com.opensymphony.xwork2.Action;

public class HelloWorldAction implements Action {
	private String content;
	private String uname;
	@Override
	public String execute() throws Exception {
		content = "你好!" + uname;
		return Action.SUCCESS;
	}
	
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
