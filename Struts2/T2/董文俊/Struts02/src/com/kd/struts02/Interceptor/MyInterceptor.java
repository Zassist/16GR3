package com.kd.struts02.Interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("开始拦截");
		String result=arg0.invoke();//请求方行
		System.out.println("返回代码"+result);
		return result;
	}

}
