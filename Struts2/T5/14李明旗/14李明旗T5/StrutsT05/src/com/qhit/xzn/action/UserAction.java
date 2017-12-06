package com.qhit.xzn.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.xzn.bean.User;
import com.qhit.xzn.service.UserService;
import com.qhit.xzn.service.imp.UserServiceImp;

public class UserAction extends ActionSupport {
	 private User user;
	  private List<User> users;
	  UserService service = new UserServiceImp();
		public String addUser(){
			try {
				service.addUser(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return ERROR;
			}
			return "success";
			
		}
		public String allUser(){
			try {
				users=service.allUser();
				return "success";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return ERROR;
			}
			
		}
		public String toupdUser(){
			try {
				user=service.getUserById(user);
				return "success";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return ERROR;
			}
			
		}
		public String updUser(){
			try {
				service.updUser(user);
				return "success";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return ERROR;
			}
			
			
		}
		public String delUser(){
			try {
				service.delUser(user);
				return "success";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return ERROR;
			}
			
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public List<User> getUsers() {
			return users;
		}
		public void setUsers(List<User> users) {
			this.users = users;
		}
		
}
