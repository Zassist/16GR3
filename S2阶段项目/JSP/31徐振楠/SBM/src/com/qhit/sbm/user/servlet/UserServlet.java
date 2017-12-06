package com.qhit.sbm.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.sbm.user.bean.User;
import com.qhit.sbm.user.service.UserService;
import com.qhit.sbm.user.service.Imp.UserServiceImp;

public class UserServlet extends HttpServlet {

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

		doPost(request,response);
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
      switch (cmd) {
	case "login":
		doLogin(request,response);
		break;

	default:
		break;
	}
		
	}

	private void doLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		UserService userService = new UserServiceImp();
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		User user=userService.doLogin(userName, passWord);
		if(user!=null){
			request.getSession().setAttribute("user", user);
			response.sendRedirect("jsp/admin_index.jsp");
		}else{
			
			response.sendRedirect("index.jsp?loginMsg=loginFial");
			
		}
	}

}
