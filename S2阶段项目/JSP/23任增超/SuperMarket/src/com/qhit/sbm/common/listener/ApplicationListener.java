package com.qhit.sbm.common.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.qhit.sbm.user.bean.User;

public class ApplicationListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("application监听器被销毁");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("application监听器初始化");
		List<User> users = new ArrayList<>();
		arg0.getServletContext().setAttribute("online", users);

	}


}
