package com.qhit.stuts;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class LoginAction implements Action {
	private String name;
	private String password;

	@Override
	public String execute() throws Exception {
		if(name.equalsIgnoreCase("admin") 
				&&
		password.equalsIgnoreCase("123456")){
            return SUCCESS;
        }
        else{
            return ERROR;
    }
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
