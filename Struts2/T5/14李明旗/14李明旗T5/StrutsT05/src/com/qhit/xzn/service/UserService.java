package com.qhit.xzn.service;

import java.util.List;



import com.qhit.xzn.bean.User;

public interface UserService {
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
