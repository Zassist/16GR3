/**
 * 
 */
package com.qhit.lh.gr3.sakura.exam.common.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.qhit.lh.gr3.sakura.exam.common.bean.User;
import com.qhit.lh.gr3.sakura.exam.common.utils.Constans;



/**
 * @author Administrator
 * TODO 登录状态验证
 * 2018-1-2下午8:16:24
 */
public class LoginInterceptor extends AbstractInterceptor {

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("登录校验拦截器");
		//通过User是否存在判断是否是登录状态
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if(user == null){
			//未登录状态
			return Constans.VIEW_LOGIN;
		}
		//登录状态
		return arg0.invoke();
	}

}
