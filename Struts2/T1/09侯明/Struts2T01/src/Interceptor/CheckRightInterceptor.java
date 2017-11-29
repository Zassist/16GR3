package Interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckRightInterceptor extends AbstractInterceptor {/*我们所设计的自定义拦截器，继承自
Struts2框架提供的抽象类AbstractInterceptor，这个抽象类实现了一个Interceptor接口*/

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		//获取会话中的与登录验证有关的属性对象
		Object value=arg0.getInvocationContext().getSession().get("loginuser");/*取出当前会话
中的属性名loginuser的对象*/
		
		//进行判断，是登录用户则请求放行，返回结果值；是匿名用户则返回“login”结果值
		if(value==null){//不存在，则是匿名用户
			return Action.LOGIN;//改变流程，应指向登录页面
		}else{//存在，则是登录用户
			System.out.println("登录信息："+value);
			return arg0.invoke();//请求放行
		}
	}

}
