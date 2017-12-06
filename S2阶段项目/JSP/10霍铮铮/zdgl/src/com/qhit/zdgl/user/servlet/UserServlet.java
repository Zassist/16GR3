package com.qhit.zdgl.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.SmartUpload;
import com.qhit.zdgl.common.bean.PageBean;
import com.qhit.zdgl.user.bean.User;
import com.qhit.zdgl.user.service.UserService;

public class UserServlet extends HttpServlet {
	private UserService us = new UserService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if(action.equals("login")){
			login(request, response);
		}else if(action.equals("all")){
			all(request,response);
		}else if(action.equals("del")){
			del(request,response);
		}else if(action.equals("like")){
			like(request,response);
		}else if(action.equals("add")){
			add(request,response);
		}else if(action.equals("preUpd")){
			preUpd(request,response);
		}else if(action.equals("upd")){
			upd(request,response);
		}else if(action.equals("exit")){
			exit(request,response);
		}
		
	}
	/**
	 * ��½
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
			String userName = request.getParameter("userName");
			String userPassword = request.getParameter("userPassword");
			User user = us.login(userName, userPassword);
			if(user!=null){
				request.getSession().setAttribute("user", user);
				response.sendRedirect("/zdgl/admin_index.jsp");
			}else{
				request.setAttribute("message", "�û������������,�����µ�½!");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
	}
	/**
	 * ��ѯ����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void all(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		int p = 1;
		String pNum = request.getParameter("p");
		if(pNum!=null){
			p = Integer.parseInt(pNum);
		}
		PageBean pb = us.selAllUser(p);
		request.setAttribute("pageBean", pb);
		request.getRequestDispatcher("/userAdmin.jsp").forward(request, response);
	}
	/**
	 * ɾ��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void del(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		int userId = Integer.parseInt(request.getParameter("userId"));
		String fileName = request.getParameter("pic");
		System.out.println(fileName);
		String filePath = request.getRealPath("/"+fileName);
		System.out.println(filePath);
		int count = us.delUser(filePath,userId);
		if(count == 1){
			request.setAttribute("message", "ɾ���ɹ�!");
		}else{
			request.setAttribute("message", "ɾ��ʧ��!");
		}
		all(request,response);
	}
	/**
	 * ģ����ѯ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void like(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		int p = 1;
		String pNum = request.getParameter("p");
		if(pNum!=null){
			p = Integer.parseInt(pNum);
		}
		String userName = request.getParameter("userName");
		PageBean pb = us.selUserLikeName(userName, p);
		request.setAttribute("pageBean", pb);
		request.setAttribute("userName", userName);
		request.getRequestDispatcher("/userAdmin.jsp").forward(request, response);
	}
	/**
	 * ���
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		//����serviceִ�����
		SmartUpload su = new SmartUpload();
		PageContext pc = JspFactory.getDefaultFactory().getPageContext(this, request, response,null, true, 8192, true);
		su.initialize(pc);
		int count = us.addUser(su);
		if(count == 1){
			request.setAttribute("message", "��ӳɹ�!");
			all(request, response);
		}else{
			request.setAttribute("message", "���ʧ��!");
			request.getRequestDispatcher("/userAdd.jsp").forward(request, response);
		}
		
	}
	/**
	 * Ԥ����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void preUpd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
			int userId = Integer.parseInt(request.getParameter("userId"));
			User user = us.preUpd(userId);
			if(user!=null){
				request.setAttribute("user", user);
				request.getRequestDispatcher("/userAdd.jsp").forward(request, response);
			}else{
				request.setAttribute("message", "�������쳣!");
				request.getRequestDispatcher("/userAdmin.jsp").forward(request, response);
				
			}
	}
	/**
	 * �޸�
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void upd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		//����serviceִ�����
		SmartUpload su = new SmartUpload();
		PageContext pc = JspFactory.getDefaultFactory().getPageContext(this, request, response,null, true, 8192, true);
		su.initialize(pc);
		int count = us.updUser(su);
		if(count == 1){
			request.setAttribute("message", "�޸ĳɹ�!");
			all(request, response);
		}else{
			request.setAttribute("message", "�޸�ʧ��!");
			request.getRequestDispatcher("/userAdd.jsp").forward(request, response);
		}
		
	}
	/**
	 * �˳�
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void exit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		request.getSession().invalidate();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		out.println("<html>");
		out.println("<head>");
		out.println("<script>");
		out.println("top.location='/zdgl/login.jsp'");
		out.println("</script>");
		out.println("</head>");
		out.println("<body>");
		out.println("111111111");
		out.println("</body>");
		out.println("</html>");
		
	}
}
