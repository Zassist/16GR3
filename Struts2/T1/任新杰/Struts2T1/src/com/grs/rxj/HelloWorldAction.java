package com.grs.rxj;

import com.opensymphony.xwork2.Action;

public class HelloWorldAction implements Action {
	private String content;
	

	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		content = "Hello,World";
		return Action.SUCCESS;
	}
}
