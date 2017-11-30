package com.grs.wjk.convertor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class DateConvertor extends StrutsTypeConverter {
	
	/**
	 * 从参数中获取字符串，进行类型转换
	 */
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		String srtDate = arg1[0];
		Date date = null;
		try {
			date = sdf.parse(srtDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 把数据转换成字符串显示到页面中
	 */
	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		return sdf.format(arg1);
	}

}
