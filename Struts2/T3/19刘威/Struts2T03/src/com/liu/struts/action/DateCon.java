package com.liu.struts.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.apache.struts2.util.StrutsTypeConverter;

public class DateCon extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date v = null;
		try {
			v = sdf.parse(arg1[0]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return v;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DateCon v = (DateCon)arg1;
		return sdf.format(v);
	}

}
