package com.cyh.test.action;

import java.util.List;

import com.cyh.test.bean.User;
import com.cyh.test.service.UserService;
import com.cyh.test.service.Impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private User user;
	private List<User> userlist;
	private UserService us=new UserServiceImpl();
	
	public String getAllUser() {
		System.out.println("getAllUser");
		try {
			userlist=us.getAllUser();
			System.out.println(userlist.size());
//			System.out.println(userlist.get(0).toString());
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
	}
	public String addUser() throws Exception {
		System.out.println("addUser");
		
//		System.out.println(user.getBirthday());
//		System.out.println(user.toString());
		if(user!=null) {
			int row=us.addUser(user);
			System.out.println("row:"+row);
			if(row>0) {
				return "toAll";
			}else{
				return ERROR;
			}		
		}else {
			System.out.println("user为null");
			return ERROR;
		}
	}
	public String deleteUser() throws Exception {
		System.out.println("deleteUser");
		System.out.println("deluser.getId():"+user.getId());
		int row=us.deleteUser(user.getId());
		if(row>0) {
			System.out.println("删除成功");
			return "toAll";
		}else {
			System.out.println("删除失败");
			return ERROR;
		}
	}
	
	public String toUpdateUser() throws Exception {
		System.out.println("toUpdateUser");
		System.out.println("user.getId():"+user.getId());
		user=us.getUserById(user.getId());
		return "toUpdate";
	}
	public String updateUser() throws Exception {
		System.out.println("updateUser");
		System.out.println("user.getId()"+user.getId());
		if(user!=null) {
			int row =us.updateUser(user);
			if(row>0) {
				return "toAll";
			}else{
				return ERROR;
			}		
		}else {
			return ERROR;
		}
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getUserlist() {
		return userlist;
	}
	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}
	public UserService getUs() {
		return us;
	}
	public void setUs(UserService us) {
		this.us = us;
	}
	
	
}
