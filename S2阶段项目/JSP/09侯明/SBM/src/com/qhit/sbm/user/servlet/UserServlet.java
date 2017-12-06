package com.qhit.sbm.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.sbm.user.bean.User;
import com.qhit.sbm.user.service.UserServiec;
import com.qhit.sbm.user.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {
	private UserServiec usService = new UserServiceImpl();

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
		switch (cmd){
		case "login":
			doLogin(request, response);
			break;
		case "exit":
			doExit(request,response);
			break;
		case "uploadPic":
			uploadPic(request,response);
			break;
		case "addUser":
			addUser(request,response);
			break;
		}
	}
	
	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 * 添加用户
	 */
	private void addUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		String userName = (String) request.getAttribute("userName");
		String userPassword = (String) request.getAttribute("userPassword");
		String userSex = (String) request.getAttribute("userSex");
		String userAge = (String) request.getAttribute("userAge");
		String telephone = (String) request.getAttribute("telephone");
		String address = (String) request.getAttribute("address");
		String type = (String) request.getAttribute("type");
		//头像服务器存储路径是request.setAttribute("picPath", picPath);
		String pic = (String) request.getAttribute("pic");
		
		User user = new User(
				userName,
				userPassword,
				userSex,
				Integer.parseInt(userAge),
				telephone,
				address,
				pic,
				Integer.parseInt(type)
				);
		int row = usService.addUser(user);
		PrintWriter out = response.getWriter();
		if(row > 0){
			//添加成功：应该重定向到user控制层重新查询所有的用户列表
			//out.print("<script>alert('添加成功');</script>");
			response.sendRedirect("jsp/userinfo.jsp?pic="+pic);
		}else{
			out.print("<script>alert('添加失败');</script>");
		}
	}

	private void uploadPic(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void doExit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		request.getSession().invalidate();
//		response.sendRedirect("index.jsp");
		PrintWriter out = response.getWriter();
		
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		
		out.print("<script>window.top.location.href='"+basePath+"'</script>");
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 * 登录功能
	 */
	private void doLogin(HttpServletRequest request,HttpServletResponse response) throws IOException {
		boolean isOnline = false;
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		
		User user = usService.doLogin(userName, userPassword);
		
		if(user != null){
			/**
			 * 登陆成功
			 * */
			//保存用户信息到会话中
			request.getSession().setAttribute("user", user);
			//获取在线用户集合
			List<User> users = (List<User>) request.getServletContext().getAttribute("online");
			for (User user2 : users) {
				if(user2.getUserId() == user.getUserId()){
					//说明当前用户已经在线,直接跳转就可以
					isOnline = true;
					break;
				}
			}
			if(isOnline){
				response.sendRedirect("jsp/admin_index.jsp");
			}else{
				//添加当前用户到在线用户集合
				users.add(user);
				//更新在线用户集合
				request.getServletContext().setAttribute("online", users);
				//跳转页面
				response.sendRedirect("jsp/admin_index.jsp");
			}
		}else{
			//登录失败
			response.sendRedirect("index.jsp?loginMsg=failed");
		}
	}

}
