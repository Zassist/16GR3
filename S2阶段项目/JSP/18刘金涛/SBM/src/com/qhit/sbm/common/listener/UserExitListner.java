package com.qhit.sbm.common.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.qhit.sbm.user.bean.User;

public class UserExitListner implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("session销毁");

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("session初始化");
		HttpSession session = arg0.getSession();
		User user = (User) session.getAttribute("user");
		ServletContext application = session.getServletContext();
		List<User> users = (List<User>) application.getAttribute("online");
		users.remove(user);
		application.setAttribute("online", users);

	}

}
