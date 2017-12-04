/**
 * 
 */
package com.kd.t5.action;

import java.util.List;

import com.kd.t5.bean.User;
import com.kd.t5.service.UserService;
import com.kd.t5.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;


public class UserAction extends ActionSupport {
	private User user;
	private List<User> users;
	
	private UserService uService = new UserServiceImpl();
	
	
	public String add() {
		//添加
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
		//删除
		try {
			uService.deleteUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return "toAll";
	}
	public String toUpdate() {
		//获取更新数据
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
		//更新
		try {
			uService.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return "toAll";
	}

	public String getAll() {
		//获取
		try {
			users = uService.getAllUser();
		} catch (Exception e) {
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
