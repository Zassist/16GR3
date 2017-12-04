package com.cyh.test1.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class converter extends StrutsTypeConverter {
/*
 * String转别的类
 * */
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dt=sdf.parse(arg1[4]);
			return dt;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("日期类型转换错误"+e.getMessage());
			return null;
		}
		
	}
	/*
	 * 别的类转String
	 * */
	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date dt=(Date)arg1;
		return sdf.format(dt);
	}

}
