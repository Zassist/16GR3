package com.qhit.xzn.dao;
import java.util.List;

import com.qhit.xzn.bean.User;

public interface UserDao {
	//查询
    public List<User> allUser() throws Exception;
	//添加
	public int addUser(User user) throws Exception;
	//去修改
	public User getUserById(User user) throws Exception;
	//修改
	public int updUser(User user)throws Exception;
	//删除
	public int delUser(User user)throws Exception;
}
