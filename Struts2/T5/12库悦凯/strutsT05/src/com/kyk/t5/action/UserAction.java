package com.kyk.t5.action;

import java.util.List;

import com.kyk.t5.bean.User;
import com.kyk.t5.service.UserService;
import com.kyk.t5.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private UserService us = new UserServiceImpl();
	private User user;
	private List<User> users;
	
	/**
	 * @return
	 * ����û�
	 */
	public String add(){
		try {
			us.addUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "toAll";
	}
	/**
	 * @return
	 * ɾ��
	 */
	public String delete(){
		try {
			us.deleteUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "toAll";
		
	}
	/**
	 * @return
	 * �޸��û���Ϣ
	 */
	public String update(){
		try {
			us.updateUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "toAll";
	}
	/**
	 * @return
	 * ��ѯ�����û�
	 */
	public String getAll(){
		try {
			us.getAllUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "listUser";
	}
	public String toUpdate() {
		try {
			user = us.getUserById(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "toUpdate";
	}
	
	
	public UserService getUs() {
		return us;
	}
	public void setUs(UserService us) {
		this.us = us;
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
