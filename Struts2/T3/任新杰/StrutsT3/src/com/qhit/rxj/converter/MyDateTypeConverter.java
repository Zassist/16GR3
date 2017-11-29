package com.qhit.rxj.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class MyDateTypeConverter extends StrutsTypeConverter {

	@Override
	//请求中获取参数进行转换
	public Object convertFromString(Map context, String[] values, Class toClass) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date v;
		try {
			v = sdf.parse(values[0]);
			return v;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("日期类型转换错误：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	//转换成字符串以供视图显示
	public String convertToString(Map context, Object obj) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date v = (Date)obj;
		return sdf.format(v);
	}

}
