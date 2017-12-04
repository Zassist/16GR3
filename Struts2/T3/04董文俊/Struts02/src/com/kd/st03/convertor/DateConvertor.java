package com.kd.st03.convertor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class DateConvertor extends StrutsTypeConverter{

	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String sd=arg1[0];
		Date date=null;
		try {
			date=sdf.parse(sd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String sd=sdf.format(arg1);
		return sd;
	}

}
