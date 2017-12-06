package com.tsing.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

// struts2默认转发路径为 WEB-INF/content/demo.jsp

@Results({	
	@Result(name="success",location="/demo.jsp",type="dispatcher")
	
})
// Hello + Action
public class HelloAction extends ActionSupport {	
	public String execute() throws Exception {
		// TODO Auto-generated method stub		
		System.out.println("=========================");
		return "success";
	}
	
}
