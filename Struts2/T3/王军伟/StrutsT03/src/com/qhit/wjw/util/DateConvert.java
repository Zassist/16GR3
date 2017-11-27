package com.qhit.wjw.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class DateConvert extends StrutsTypeConverter{
	
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		Date date = new Date();
		try {
			date = df.parse(arg1[0]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		Date date = (Date)arg1;
		return df.format(date);
	}

}
