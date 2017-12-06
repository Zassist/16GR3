package com.liu.Struts.action;
import java.util.List;

import com.liu.Struts.bean.User;
import com.liu.Struts.service.UserService;
import com.liu.Struts.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport  {
	private User user;
	private List<User> users;
	
	private UserService userser = new UserServiceImpl();
	public String add(){
		try {
			userser.add(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "add";
	}

	public String getAll(){
		try {
			users = userser.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	public String toUpdate(){
		try {
			user = userser.getUserById(this.user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "toupdate";
	}
	public String update(){
		try {
			userser.updateUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "update";
	}
	public String delete(){
		try {
			userser.deleteUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "delete";
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
