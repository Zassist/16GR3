package com.grs.wjk.action;

import java.util.List;

import com.grs.wjk.bean.User;
import com.grs.wjk.service.UserService;
import com.grs.wjk.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private User user;
	private List<User> users;
	private UserService userService = new UserServiceImpl();
	
	/**
	 * @return
	 * 添加
	 */
	public String add() {
		try {
			userService.add(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "toAll";
	}
	
	/**
	 * @return
	 * 删除
	 */
	public String delete() {
		try {
			userService.del(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "toAll";
	}
	
	/**
	 * @return
	 * 先查询当前用户信息，再跳转到修改页面
	 */
	public String toupdate() {
		try {
			user = userService.getAllById(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "toUpdate";
	}
	
	/**
	 * @return
	 * 更新
	 */
	public String update() {
		try {
			userService.upd(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "toAll";
	}
	
	/**
	 * @return
	 * 查询所有
	 */
	public String getAll() {
		try {
			users = userService.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "listUser";
	}
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
