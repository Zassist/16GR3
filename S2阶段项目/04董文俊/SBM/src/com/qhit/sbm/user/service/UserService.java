package com.qhit.sbm.user.service;

import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.user.bean.User;

public interface UserService {
	
	//登录
	public User doLogin(String userName,String userPassword);
	//添加
	public int addUser(User user);
	//获取所有用户
	public PageBean getPageBean(PageBean pageBean);
	//删除
	public int delUser(int userId);
}
