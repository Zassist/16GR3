/**
 * 
 */
package com.jt.struts.action;

import java.util.List;

import com.jt.struts.bean.User;
import com.jt.struts.service.UserService;
import com.jt.struts.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author JT
 *
 */
public class UserAction extends ActionSupport {
	private User user;
	private List<User> users;
	
	private UserService uService = new UserServiceImpl();
	
	public String add() {
		try {
			uService.addUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "toAll";
	}

	public String delete() {
		try {
			uService.deleteUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "toAll";
	}

	public String toUpdate() {
		try {
			user = uService.getUserById(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "toUpdate";
	}

	public String update() {
		try {
			uService.updateUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "toAll";
	}

	public String getAll() {
		try {
			users = uService.getAllUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "listUser";
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
