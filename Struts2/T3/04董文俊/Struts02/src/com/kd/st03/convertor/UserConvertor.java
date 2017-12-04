package com.kd.st03.convertor;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.kd.st03.bean.User;

public class UserConvertor  extends StrutsTypeConverter{

	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		String uname=arg1[0];
		String pwd=arg1[1];
		String age=arg1[2];
		String telphone=arg1[4];
		User u=new User();
		u.setUname(uname);
		u.setAge(Integer.parseInt(age));
		u.setTelphone(telphone);
		u.setPwd(pwd);
		return u;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		User user = (User) arg1;
		return user.toString();
	}

}
