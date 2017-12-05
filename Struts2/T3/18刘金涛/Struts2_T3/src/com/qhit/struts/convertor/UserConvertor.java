package com.qhit.struts.convertor;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.qhit.struts.bean.User;

public class UserConvertor extends StrutsTypeConverter{

	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		String uname = arg1[0];
		String upwd = arg1[1];
		String age = arg1[2];
		String birthday = arg1[3];
		String sex = arg1[4];
		String address = arg1[5];
		String telphone = arg1[6];
		User user = new User();
		user.setUname(uname);
		user.setUpwd(upwd);
		user.setSex(sex);
		user.setAddress(address);
		
		return user;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		User user = (User) arg1;
		return user.getInfo();
	}

}
