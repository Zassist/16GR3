package com.asa.T5.action;

import java.sql.SQLException;
import java.util.List;

import com.asa.T5.bean.User;
import com.asa.T5.service.UserService;
import com.asa.T5.service.Impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private User user;
	private List<User> users;
	
	private UserService uService = new UserServiceImpl();
	
	public String add(){
		try {
			uService.addUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "add";
	}
	
	public String delete(){
		try {
			uService.deleteUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "delete";
	}
	
	/**
	 * @return
	 * 先查询当前用户信息，再跳转到修改页面
	 */
	public String toUpdate(){
		try {
			user = uService.getUserById(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "toUpdate";
	}
	
	/**
	 * @return
	 * 修改用户信息
	 */
	
	public String update(){
		try {
			uService.updateUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "update";
	}
	
	/**
	 * @return
	 * 查询所有的用户
	 */
	
	public String getAll(){
		try {
			users = uService.getAllUser();
		} catch (SQLException e) {
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
