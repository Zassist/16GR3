package com.qhit.sbms.common.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.qhit.sbms.user.bean.User;

public class ApplicationListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("Ӧ�ó���ֹͣ������");

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Ӧ�ó����ʼ��");
		List<User> users = new ArrayList<>();
		arg0.getServletContext().setAttribute("online", users);

	}

}
