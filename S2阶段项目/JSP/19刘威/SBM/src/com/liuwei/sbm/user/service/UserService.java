package com.liuwei.sbm.user.service;

import com.liuwei.sbm.conmon.bean.PageBean;
import com.liuwei.sbm.user.bean.User;

public interface UserService {
	/**
	 * @param userName
	 * @param passWord
	 * @return
	 * ��¼��ҵ��
	 */
	public User doLogin(String userName,String userPassword);
	public User getUsers(User users); 
}
