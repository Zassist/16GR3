package Interceptor;

import javax.swing.plaf.basic.BasicComboPopup.InvocationKeyHandler;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckCount extends AbstractInterceptor {/*我们所设计的自定义拦截器，继承自Struts2框架提供的
抽象类AbstractInterceptor，这个抽象类实现了一个Interceptor接口*/

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		//获取会话中的与登录验证有关的属性对象
		String value=arg0.getInvocationContext().getSession().get("loginuser").toString();/*取出当前会话
中的属性名loginuser的对象*/
		if(value.length()<3){//用户名长度小于3
			return Action.LOGIN;
		}else{
			return arg0.invoke(); 
		}
		
	}

}
