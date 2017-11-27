package com.qhit.jack.action;

import com.opensymphony.xwork2.Action;

public class HelloAction implements Action {
	private String num ;
	private String uname;
	
	@Override
	public String execute() throws Exception {
		num = "ÄãºÃ!"+ uname;
		
		
		return "qwer";
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}
	
}
