package com.qhit.sbm.user.dao;

import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.user.bean.User;

public interface UserDao {
	public User doLogin(String userName,String userPassword);
	//添加
	public int addUser(User user);
	//获取
	public PageBean getPageBean(PageBean pageBean);
	//删除
	public int delUser(int userId);
}
