package com.tsing.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

@Results( 
		{
		@Result(name = "list", location = "/list.jsp",type="dispatcher"),
		@Result(name = "edit", location = "/edit.jsp",type="dispatcher" ),
		@Result(name = "del", location = "/del.jsp",type="dispatcher") }

)

public class EmployeeAction extends ActionSupport {

	// employee!list
	// employee!edit
	@Action(value="employeeAction")
	public String list() {
		return "list";
	}

	public String edit() {
		return "edit";
	}

	public String delete() {
		return "del";
	}

}
