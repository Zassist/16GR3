package com.qhit.wjw.dao.impl;

import com.opensymphony.xwork2.ActionInvocation;
import com.qhit.wjw.dao.Interceptor;

public abstract class AbstractInterceptor implements Interceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("我开始拦截");
		String result = invocation.invoke();
		System.out.println("返回代码"+result);
		return result;
	}

}
