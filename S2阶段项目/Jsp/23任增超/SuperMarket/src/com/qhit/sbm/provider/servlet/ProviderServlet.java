package com.qhit.sbm.provider.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.sbm.provider.bean.Provider;
import com.qhit.sbm.provider.service.ProviderService;
import com.qhit.sbm.provider.service.impl.ProviderServiceImpl;

/**
 * Servlet implementation class ProviderServlet
 */
@WebServlet("/ProviderServlet")
public class ProviderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProviderService providerService = new ProviderServiceImpl();
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
	case "getAllProvider":
		getAllProvider(request, response);
		break;

	case "addProvider":
		addProvider(request,response);
		break;

	default:
		break;
	}
	}

	private void getAllProvider(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Provider> list = providerService.getAllProvider();
		String action = request.getParameter("action");
		request.setAttribute("providers", list);
		if(action.equals("add")){
			//查完之后:如果是添加账单，转发到添加账单的页面
			RequestDispatcher rqDispatcher = request.getRequestDispatcher("jsp/modify.jsp");
			rqDispatcher.forward(request, response);
		}else{
			//查完之后：如果是修改账单，那就转发到修改账单的页面
			RequestDispatcher rqDispatcher = request.getRequestDispatcher("jsp/updateAccount.jsp");
			rqDispatcher.forward(request, response);
		}
	}

	private void addProvider(HttpServletRequest request, HttpServletResponse response) {
	 	String providerName = request.getParameter("providerName");
	 	String providerDetail = request.getParameter("providerDetail");
	 	String contact = request.getParameter("contact");
	 	String telephone = request.getParameter("telephone");
	 	String facsimile = request.getParameter("facsimile");
	 	String address = request.getParameter("address");
		Provider provider = new Provider(providerName, providerDetail, contact, telephone, facsimile, address);
		int row = providerService.addProvider(provider);
		
		if(row > 0) {
			//插入成功 重定向
			
		}else {
			//插入失敗
			System.out.println("插入失敗");
		}
	}

}
