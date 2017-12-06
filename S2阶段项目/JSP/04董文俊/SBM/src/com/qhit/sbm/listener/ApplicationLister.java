package com.qhit.sbm.listener;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import com.qhit.sbm.user.bean.User;


/**
 * Application Lifecycle Listener implementation class ApplicationLister
 *
 */
@WebListener
public class ApplicationLister implements ServletContextListener  {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		//销毁
		arg0.getServletContext().removeAttribute("onlines");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//创建在线集合
		List<User> onlines =new ArrayList<User>();
		arg0.getServletContext().setAttribute("onlines", onlines);
		
	}



}
