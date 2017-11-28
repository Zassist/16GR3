package com.java.t3.convertor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class DateConvertor extends StrutsTypeConverter{

	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date v = sdf.parse(arg1[0]);
			return v;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		     System.out.println("日期类型转换错误："+e.getMessage());
		return null;
	}
		
}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date v = (Date)arg1;
		return sdf.format(v);
	}

}
