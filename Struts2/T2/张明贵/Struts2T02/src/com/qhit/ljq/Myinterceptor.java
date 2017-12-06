package com.qhit.ljq;

import org.eclipse.jdt.internal.compiler.ast.Invocation;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Myinterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("我开始拦截。。。");
		String result =Invocation.invoke();
		System.out.println("返回代码"+result);
		return result;
	}

}
