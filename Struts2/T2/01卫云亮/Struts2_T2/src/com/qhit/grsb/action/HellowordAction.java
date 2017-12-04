package com.qhit.grsb.action;

import com.opensymphony.xwork2.Action;

public class HellowordAction implements Action {
	private String content="������־ʤ";
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return Action.SUCCESS;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
		}
}
