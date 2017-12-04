package com.liuwei.sbm.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liuwei.sbm.user.bean.User;
import com.liuwei.sbm.user.service.UserService;
import com.liuwei.sbm.user.service.impl.UserServiceimpl;

public class UserServlet extends HttpServlet {
	private UserService userService = new UserServiceimpl();
	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 doPost(request, response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cmd = request.getParameter("cmd");
		switch (cmd) {
		case "login": 
			doLogin(request,response);
			break;
		case "exit":
			doExit(request,response);
		default:
			break;
		}
	}

	private void doExit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
		response.sendRedirect("index.jsp");
		PrintWriter out = response.getWriter();
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		
		out.print("<script>window.top.location.href='"+basePath+"'</script>");
		
	}

	private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		// TODO Auto-generated method stub
		boolean isOnline = false;
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		User user = userService.doLogin(userName, userPassword);
		if(user != null){
			/*
			 * 登陆成功
			 */
			request.getSession().setAttribute("user", user);
			//获取在线集合	
			List<User> users = (List<User>) request.getServletContext().getAttribute("online");
			for(User user2: users){
				if(user2.getUserId()==user.getUserId()){
					isOnline = true;
					break;
				}
			}
			if(!isOnline){
				//添加当前用户到在线用户集合
				users.add(user);
				//更新在线用户集合
				request.getServletContext().setAttribute("online", users);
			}
			System.out.println("cmd");
			response.sendRedirect("account?cmd=getPageBean");
		}else{
			//登陆失败
			response.sendRedirect("index.jsp?loginMsg=failed");
		}
		
	}

}
