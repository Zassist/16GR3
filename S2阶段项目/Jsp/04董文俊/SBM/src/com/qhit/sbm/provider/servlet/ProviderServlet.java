package com.qhit.sbm.provider.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.common.service.CommonService;
import com.qhit.sbm.common.service.impl.CommonServiceImpl;
import com.qhit.sbm.provider.bean.Provider;
import com.qhit.sbm.provider.service.ProviderService;
import com.qhit.sbm.provider.service.impl.ProviderServiceImpl;

public class ProviderServlet extends HttpServlet {
	private ProviderService prService=new ProviderServiceImpl();
	private CommonService cmService=new CommonServiceImpl();
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

		String cmd=request.getParameter("cmd");
		switch (cmd) {
		case "getProviders":
			getProviders(request,response);
			break;
		case "allProvider":
			allProvider(request,response);
			break;
		case "delProvider":
			delProvider(request,response);
			break;
		case "addProvider":
			addProvider(request,response);
			break;
		case "getProvicerByName":
			getProvicerByName(request,response);
			break;
		default:
			break;
		}
	}

	private void getProvicerByName(HttpServletRequest request, HttpServletResponse response) {
		String providerName=request.getParameter("providerName");
		
	}

	private void addProvider(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String providerName  =request.getParameter("providerName");
		String providerDetail =request.getParameter("providerDetail");
		String contact =request.getParameter("contact");
		String telephone=request.getParameter("telephone");
		String facsimile=request.getParameter("facsimile");
		String address=request.getParameter("address");
		int count =prService.addProvider(providerName, providerDetail, contact, telephone, facsimile, address);
		if(count >0){
			//添加成功 重定向到表格页面
			response.sendRedirect("provider?cmd=allProvider&p=1");
		}else{
			//添加失败
			PrintWriter out = response.getWriter();
			out.print("<script>alert('添加失败');</script>");
		}
	}

	private void delProvider(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 删除供应商
		String providerId=request.getParameter("providerId");
		int count=prService.delProvider(Integer.parseInt(providerId));
		if(count >0){
			//添加成功 重定向到表格页面
			response.sendRedirect("provider?cmd=allProvider&p=1");
		}else{
			//添加失败
			PrintWriter out = response.getWriter();
			out.print("<script>alert('删除失败');</script>");
		}
		
	}


	private void allProvider(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		PageBean pageBean=new PageBean();
		/*
		 * 1,设置count
		 * 2,设置pagesize
		 * 3,P
		 */
		pageBean.setCount(cmService.getCount("tb_provider", null, null));
		String p=request.getParameter("p");
		if(p !=null && p != ""){
			//有参数P
			pageBean.setP(Integer.parseInt(p));
		}else{
			//没有参数P
			pageBean.setP(1);
		}
		pageBean = prService.getPageBeanProvider(pageBean);
		//保存数据到session
		request.getSession().setAttribute("pageBean", pageBean);
		if(p != null && p != ""){
			PrintWriter out=response.getWriter();
			out.print("<script>location.href='jsp/providerAdmin.jsp'</script>");
		}else{
		//重定向到
		response.sendRedirect("jsp/providerAdmin.jsp");
		}
	}

	private void getProviders(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		List<Provider> list=prService.getProvider();
		//传入请求对象
		request.setAttribute("providers", list);
		//判断是添加还是修改
		if(action.equalsIgnoreCase("addAccount")){
			//添加
			RequestDispatcher rqDispatcher = request.getRequestDispatcher("jsp/modify.jsp");
			rqDispatcher.forward(request, response);
		}else{
			//修改
			RequestDispatcher rqDispatcher = request.getRequestDispatcher("jsp/updateAccount.jsp");
			rqDispatcher.forward(request, response);
		}
		
	}

}
