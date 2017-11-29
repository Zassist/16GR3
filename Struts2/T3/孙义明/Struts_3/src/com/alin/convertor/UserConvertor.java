/**
 * 
 */
package com.alin.convertor;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.alin.bean.User;

public class UserConvertor extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		// TODO Auto-generated method stub
		String uname = arg1[0];
		String upwd = arg1[1];
		String age = arg1[2];
		String sex = arg1[3];
		String brith = arg1[4];
		String phone = arg1[5];
		User user = new User();
		user.setUname(uname);
		user.setUpwd(upwd);
		user.setSex(sex);
		return user;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		User user = (User) arg1;
		return user.toString();
	}
}
