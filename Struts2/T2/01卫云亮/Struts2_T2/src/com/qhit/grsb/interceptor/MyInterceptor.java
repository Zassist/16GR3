package com.qhit.grsb.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


@SuppressWarnings("serial")
public class MyInterceptor extends AbstractInterceptor{
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("��Ҫ��ʼ������");
		String result = invocation.invoke();//������У�������һ����������Action���
		System.out.println("���ش���:"+ result);
		// TODO Auto-generated method stub
		return result;//������ͼ������
	}

}
