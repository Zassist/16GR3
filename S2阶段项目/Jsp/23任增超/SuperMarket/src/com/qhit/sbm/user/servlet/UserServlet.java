package com.qhit.sbm.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.sbm.user.bean.User;
import com.qhit.sbm.user.service.UserService;
import com.qhit.sbm.user.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		switch (cmd) {
		case "login":
			doLogin(request,response);
			break;
		case "exit":
			doExit(request, response);
		default:
			break;
		}
	}

	private void doExit(HttpServletRequest request, HttpServletResponse response) throws IOException {

		request.getSession().invalidate();
		PrintWriter out = response.getWriter();
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		out.print("<script>window.top.location.href='"+basePath+"'</script>");
	
	}

	private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		boolean isOnline = true;
	 	User user = userService.doLogin(userName, userPassword);
	 	if(user!=null) {
	 		request.getSession().setAttribute("user", user);
	 		List<User> users = (List<User>) request.getServletContext().getAttribute("online");
//	 		for (User user2 : users) {
//				if(user2.getUserId() == user.getUserId()){
//					isOnline = true;
//					break;
//				}
//			}
	 		if(isOnline){
				response.sendRedirect("AccountServlet?cmd=getPageBean");
			}else{
				users.add(user);
				request.getServletContext().setAttribute("online", users);
				response.sendRedirect("jsp/admin_index.jsp");
			}
	 	}else {
	 		response.sendRedirect("index.jsp?loginMsg=loginFail");
		}
	}

}
