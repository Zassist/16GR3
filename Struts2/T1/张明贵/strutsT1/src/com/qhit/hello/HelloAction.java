package com.qhit.hello;

import com.opensymphony.xwork2.Action;

public class HelloAction implements Action{
	@Override
	
	public String execute() throws Exception {
		System.out.println("执行了helloaction");
		return "success";
	}

}
