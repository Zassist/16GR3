package com.asa.t4.action;

import com.asa.t4.bean.User;
import com.asa.t4.service.UserService;
import com.asa.t4.service.Impl.UserServiceImpl;
import com.opensymphony.xwork2.Action;

public class UserAction implements Action {
	UserService service= new UserServiceImpl();
    private User user;
    private int row;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
       row=service.addUser(user);
       if(row>0){
    	   return SUCCESS;
       }else{
    	   return ERROR;
       }
	
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
