package com.grs.wjk.convertor;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.grs.wjk.bean.User;

public class UserConvertor extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		// TODO Auto-generated method stub
		String uname = arg1[0];
		String password = arg1[1];
		String sex = arg1[2];
		String age = arg1[3];
		String time = arg1[4];
		String address = arg1[5];
		String telphone = arg1[6];
		User user = new User();
		user.setTime(time);
		user.setUname(uname);
		user.setPassword(password);
		user.setSex(sex);
		user.setAddress(address);
		return user;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		User user = (User) arg1;
		return user.getInfo();
	}

}
