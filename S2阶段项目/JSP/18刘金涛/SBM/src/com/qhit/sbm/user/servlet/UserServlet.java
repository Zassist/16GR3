package com.qhit.sbm.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.sbm.user.bean.User;
import com.qhit.sbm.user.service.impl.UserserviceImpl;

public class UserServlet extends HttpServlet {
	private UserserviceImpl usService = new UserserviceImpl();

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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
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
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
			String cmd = request.getParameter("cmd");
			switch(cmd){
			case "login" :
				doLogin(request,response);
//			case "exit" :
//				doExit(request,response);
			}


	}
	
	/**
	 * 退出
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	//private void doExit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//request.getSession().invalidate();
//		response.sendRedirect("index.jsp");
//		PrintWriter out = response.getWriter();
//		
//		String path = request.getContextPath();
//		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//		out.print("<script>window.top.location.herf='"+basePath+"'</script>");
		
//	}
	
	/**
	 * 登陆
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Boolean isOnline = false;
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		User user = usService.doLogin(userName, userPassword);
		
		if(user != null){
			request.getSession().setAttribute("user", user);
			List<User> users = (List<User>) request.getServletContext().getAttribute("online");
			for(User user2 : users){
				if(user2.getUserId() ==user.getUserId()){
					isOnline = true;
					break;
				}
			}
			if(!isOnline){
				users.add(user);
				request.getServletContext().setAttribute("online", users);
				
			}
			response.sendRedirect("account?cmd=getpageBean");
		}else{
			response.sendRedirect("index.jsp?loginMsg=failed+");
		}
		
	}

}
