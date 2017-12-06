package com.qhit.t4.action;

import com.opensymphony.xwork2.Action;
import com.qhit.t4.bean.UserBean;
import com.qhit.t4.dao.UserDao;
import com.qhit.t4.dao.impl.UserDaoImpl;

public class UserAction implements Action {
		
		private UserBean userbean;
	
	@Override
	public String execute() throws Exception {
		UserDao adduser = new UserDaoImpl();
		int row =adduser.AddUser(userbean);
		if(row>0){
			return SUCCESS;
			
		}else{
			return ERROR;
			
		}

		
		
	}

	public UserBean getUserbean() {
		return userbean;
	}

	public void setUserbean(UserBean userbean) {
		this.userbean = userbean;
	}

}
