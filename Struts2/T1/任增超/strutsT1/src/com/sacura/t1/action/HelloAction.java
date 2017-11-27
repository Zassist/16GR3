package com.sacura.t1.action;

import com.opensymphony.xwork2.Action;

public class HelloAction implements Action {
	private String context;
	
	@Override
	public String execute() throws Exception {
		context = "Hello World";
		return Action.SUCCESS;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

}
