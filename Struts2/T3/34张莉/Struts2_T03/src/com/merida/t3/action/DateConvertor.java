package com.merida.t3.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

public class DateConvertor extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		// TODO 帮助实现字符串与日期之间的转换
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date v = null;
		try {
			v = sdf.parse(arg1[0]);
			/*使用SimpleDateFormat实例的parse（）方法将字符串解析成java.util.Date
			类型，这里的字符串来自values数组的第一个元素*/
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return v;//解析成功返回解析后的Date对象
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date v = (Date)arg1;
		return sdf.format(v);
	}

}
