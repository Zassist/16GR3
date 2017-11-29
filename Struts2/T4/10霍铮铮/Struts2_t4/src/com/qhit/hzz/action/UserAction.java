package com.qhit.hzz.action;

import com.opensymphony.xwork2.Action;
import com.qhit.hzz.bean.User;
import com.qhit.hzz.service.UserService;
import com.qhit.hzz.service.impl.UserServiceImpl;

public class UserAction {
  private User user;
  private UserService uservice = new UserServiceImpl();

  
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//注册
       int row =uservice.addUser(user);
       if(row>0){
		return "SUCCESS";
       }else{
    	   return "error";
    	   
       }
	
	}
	  public String delete(){
		return "success";  
	  }
	  public String update(){
			return "success";  
		  }
	  public String queryAll(){
			return "success";  
		  }
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
