package com.qhit.sbms.user.service;

import com.qhit.sbms.common.bean.PageBean;
import com.qhit.sbms.user.bean.User;

/**
 * @author ���ÿ�
 *
 */
public interface UserService {
	/**
	 * @param pagebean
	 * @return
	 * ��ҳ�����ݷ���
	 */
	public PageBean getPageBeanU(PageBean pagebean);
	/**
	 * @param user
	 * @return
	 * ����û�
	 */
	public int addUser(User user);
	/**
	 * @param userName
	 * @param userPassword
	 * @return
	 * ��½��ҵ��
	 */
	public User doLogin(String userName,String userPassword);
}
