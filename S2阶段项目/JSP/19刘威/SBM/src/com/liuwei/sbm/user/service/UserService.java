package com.liuwei.sbm.user.service;

import com.liuwei.sbm.conmon.bean.PageBean;
import com.liuwei.sbm.user.bean.User;

public interface UserService {
	/**
	 * @param userName
	 * @param passWord
	 * @return
	 * µÇÂ¼µÄÒµÎñ
	 */
	public User doLogin(String userName,String userPassword);
	public User getUsers(User users); 
}
