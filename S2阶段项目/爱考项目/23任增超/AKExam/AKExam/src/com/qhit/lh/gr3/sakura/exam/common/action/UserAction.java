package com.qhit.lh.gr3.sakura.exam.common.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.gr3.sakura.exam.common.bean.User;
import com.qhit.lh.gr3.sakura.exam.common.service.UserService;
import com.qhit.lh.gr3.sakura.exam.common.service.impl.UserServiceImpl;


/**
 * @author S01
 * 2018年1月3日上午10:04:03
 * TODO 用户操作
 */
public class UserAction extends ActionSupport {
	private UserService userService = new UserServiceImpl();
	private User user;
	
	public String login(){
		user = userService.login(user);
		//用User的值判断是否登录成功
		if(user == null){
			//登录失败
			super.addActionError("用户名或密码错误!");
			return "loginFail";
		}else{
			//登录成功，将User存入Session
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			return "loginSuccess";
		}
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
