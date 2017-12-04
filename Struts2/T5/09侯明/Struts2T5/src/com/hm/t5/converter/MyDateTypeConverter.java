package com.hm.t5.converter;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class MyDateTypeConverter extends StrutsTypeConverter{

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		// TODO Auto-generated method stub
		System.out.println("日期类型开始！");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dt=(Date) sdf.parse(values[2]);
			System.out.println("日期类型转换成功！");
			return dt;
		} catch (ParseException e) {
			System.out.println("日期类型转换错误！"+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String convertToString(Map context, Object o) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date dt=(Date)o;
		return sdf.format(dt);
	}

}
