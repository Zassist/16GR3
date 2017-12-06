package com.qhit.t06.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.t06.bean.User;

public class UserAction extends ActionSupport {
   private User user;
   
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if("".equals(user.getUname())) {
			//�д���--�����������Ϣ
			super.addFieldError("user.uname", getText("uname.empty"));
		}
		if("".equals(user.getUpwd())) {
			//�д���--�����������Ϣ
			super.addFieldError("user.upwd", getText("password.empty"));
		}
		//���ݸ�ʽ����֤��������Ч����֤��������ʽ���û��������䡢�ֻ��š����룩
		Pattern pattern = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
		Matcher matcher = pattern.matcher(user.getUname());
		if(!matcher.matches()) {
			//��֤��ͨ��
			super.addFieldError("user.uname", getText("uname.formatError"));
		}
	}

	public String login() {
		
		return "loginSuccess";
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
}

