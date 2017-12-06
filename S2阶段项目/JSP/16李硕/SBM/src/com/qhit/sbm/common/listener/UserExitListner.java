package com.qhit.sbm.common.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.qhit.sbm.user.bean.User;

/**
 * Application Lifecycle Listener implementation class UserExitListner
 *
 */
@WebListener
public class UserExitListner implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public UserExitListner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("session初始化");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("session销毁");
    	HttpSession session = arg0.getSession();
    	User user = (User) session.getAttribute("user");
    	//先获取application对象
    	ServletContext application=session.getServletContext();
    	//获取在线用户集合
    	List<User> users= (List<User>) application.getAttribute("online");
    	//从当前用户集合中移除当前推出的用户
    	users.remove(user);
    	//更新application对象在线用户集合
    	application.setAttribute("online", users);
    }
	
}
