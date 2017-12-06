package com.merida.t1.action;

import com.opensymphony.xwork2.Action;

public class HelloAction implements Action {
    private String content;
    private String uname;
    
    
	@Override
	public String execute() throws Exception {
		// TODO 处理业务
		content = "你好"+uname;
		return Action.SUCCESS;
	}


	public String getContent() {
		return content;
	}


	public String getUname() {
		return uname;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}

}
