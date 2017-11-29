package com.jay.t04.dao;

import com.jay.t04.bean.User;

public interface UserDao {
	 /**
     * @param user
     * @return
     * 注册
     */
    public int addUser(User user);
}
