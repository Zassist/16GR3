package Interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor extends AbstractInterceptor {/*我们所设计的自定义拦截器，继承自Struts2框架提供
的抽象类AbstractInterceptor，这个抽象类实现了一个Interceptor接口*/
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("我要开始拦截......");
		String result=arg0.invoke();//请求放行，交给下一个拦截器或Action组件
		System.out.println("返回代码："+result);
		return result;//返回视图结果代码
	}

}
