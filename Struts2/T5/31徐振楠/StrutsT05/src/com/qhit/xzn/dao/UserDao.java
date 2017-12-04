package com.qhit.xzn.dao;
import java.util.List;

import com.qhit.xzn.bean.User;

public interface UserDao {
	//��ѯ
    public List<User> allUser() throws Exception;
	//���
	public int addUser(User user) throws Exception;
	//ȥ�޸�
	public User getUserById(User user) throws Exception;
	//�޸�
	public int updUser(User user)throws Exception;
	//ɾ��
	public int delUser(User user)throws Exception;
}
