package com.qhit.sbm.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.qhit.sbm.user.bean.User;

/**
 * Application Lifecycle Listener implementation class UserExitLister
 *
 */
@WebListener
public class UserExitLister implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public UserExitLister() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
        System.out.println("session销毁");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         System.out.println("session初始化");
         HttpSession session=arg0.getSession();
         User user=(User) session.getAttribute("user");
         ServletContext application=session.getServletContext();
         List<User> onlines=(List<User>) application.getAttribute("onlines");
         onlines.remove(user);
         application.setAttribute("onlines", onlines);
    }
	
}
