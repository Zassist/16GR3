package com.sacura.t2.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor extends AbstractInterceptor {


	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("我要开始拦截》》》");
		String result = invocation.invoke();
		return result;
	}

}
