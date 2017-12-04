package com.liuwei.sbm.provider.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liuwei.sbm.provider.bean.Provider;
import com.liuwei.sbm.provider.service.ProviderService;
import com.liuwei.sbm.provider.service.impl.ProviderServiceimpl;

public class ProviderServlet extends HttpServlet {
	private ProviderService providerService = new ProviderServiceimpl();
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
		case "getAllProvider":
			getAllProvider(request,response);
			break;
		case "Providerinfo":
			getProviderinfo(request,response);
		default:
			break;
		}
	}

	private void getProviderinfo(HttpServletRequest request, HttpServletResponse response) {
		Provider pro=new Provider();
		  String id= request.getParameter("proId");
		 int a= Integer.parseInt(id);
		 pro= providerService.selectProviderDeil(a);
		  request.getSession().setAttribute("a", pro);
		  try {
			response.sendRedirect("providerinfo.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getAllProvider(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		List<Provider> list = providerService.getAllProvider();
		request.setAttribute("providers",list);
		
		if(action.equals("add")){
			RequestDispatcher rqDispacher = request.getRequestDispatcher("jsp/modify.jsp");
			rqDispacher.forward(request, response);
		}else{
			RequestDispatcher rqDispacher = request.getRequestDispatcher("jsp/updateAccount.jsp");
			rqDispacher.forward(request, response);
		}
	}

}
