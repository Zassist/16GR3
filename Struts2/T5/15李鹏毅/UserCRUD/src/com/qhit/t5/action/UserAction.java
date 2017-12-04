package com.qhit.t5.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.t5.bean.UserBean;
import com.qhit.t5.service.UserService;
import com.qhit.t5.service.Impl.UserServiceImpl;

public class UserAction extends ActionSupport {
	private UserBean userbean;
	private UserService userService = new UserServiceImpl();
	
	private List<UserBean> list = new ArrayList<UserBean>();

	/**
	 * @return
	 * Ìí¼Ó
	 */
	
	public String toUpdate(){
		userbean=userService.getUserbyId(userbean.getId());
		return "update";
	}
	public String add(){
		if(userbean!=null){
		try {
			userService.addUser(userbean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return "tolist";
	}
	public String getAll(){
		try {
			list=userService.getAllUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "list";
	}
	
	
	public String update (){
		if(userbean!=null){
		}
		return "tolist";
	}
	
	public String delete(){
		try {
			userService.delUser(userbean.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "tolist";
	}
	
	public UserBean getUserbean() {
		return userbean;
	}

	public void setUserbean(UserBean userbean) {
		this.userbean = userbean;
	}

	public List<UserBean> getList() {
		return list;
	}

	public void setList(List<UserBean> list) {
		this.list = list;
	}
}
