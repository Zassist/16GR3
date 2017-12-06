package com.qhit.smb.common.listener;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.qhit.smb.User.bean.User;
/**
 * 
 * @author 子华再世
 *
 */
@WebListener
public class ApplicationListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("监听器已经上线");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("监听器已经上线");
		List<User> users = new ArrayList<>();
		arg0.getServletContext().setAttribute("online", users);
	}

}
