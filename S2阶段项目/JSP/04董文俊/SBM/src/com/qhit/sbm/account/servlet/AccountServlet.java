package com.qhit.sbm.account.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.sbm.account.service.AccountService;
import com.qhit.sbm.account.service.impl.AccountServiceImpl;
import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.common.service.CommonService;
import com.qhit.sbm.common.service.impl.CommonServiceImpl;
import com.qhit.sbm.goods.bean.Goods;

public class AccountServlet extends HttpServlet {
	private CommonService cmService=new CommonServiceImpl();
	private AccountService acService=new AccountServiceImpl();
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
		System.out.println(cmd);
		switch (cmd) {
		case "allAccount":
			allAccount(request,response);
			break;
			
		case "addAccount":
			addAccount(request,response);
			break;
		case "updateAccount":
			updateAccount(request,response);
			break;
		case "deleteAccount":
			deleteAccount(request,response);
			break;
		case "getAccountBywhere":
			getAccountBywhere(request,response);
			break;

		default:
			break;
		}
		
	}



	private void getAccountBywhere(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//条件查询
		String goodsName = request.getParameter("goodsName");
		String isPayed = request.getParameter("isPayed");
		List<Object> wheres = new ArrayList<Object>();
		List<Object> values = new ArrayList<Object>();
		if(goodsName != null && goodsName != ""){
			wheres.add("g.goodsName");
			values.add(goodsName);
		}
		if(isPayed != null && isPayed != ""){
			wheres.add("a.isPayed");
			values.add(isPayed);
		}
		
		PageBean pageBean = acService.getPageBeanBywhere(wheres, values);
		
		request.getSession().setAttribute("pageBean", pageBean);
		
		PrintWriter out = response.getWriter();
		out.print("<script>location.href = 'jsp/admin_bill_list.jsp'</script>");
		
	}

	private void deleteAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//删除
		String accountId = request.getParameter("accountId");
		
		int count = acService.deleteAccountById(Integer.parseInt(accountId));
		
		if(count > 0){
			//删除成功
			response.sendRedirect("account?cmd=allAccount&&p=1");
		}else{
			//删除失败
			PrintWriter out = response.getWriter();
			out.print("<script>alert('删除失败');</script>");
		}
		
	}

	private void updateAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//跟新
		String accountId = request.getParameter("accountId");
		String providerId = request.getParameter("providerId");
		String isPayed = request.getParameter("isPayed");
		int count=acService.upDateAccountById(Integer.parseInt(accountId), Integer.parseInt(providerId), Integer.parseInt(isPayed));
		if(count > 0){
			//更新成功
			response.sendRedirect("account?cmd=allAccount&&p=1");
		}else{
			//更新失败
			PrintWriter out = response.getWriter();
			out.print("<script>alert('更新失败');</script>");
		}
		
	}

	private void addAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//接受商品信息
		Goods goods=(Goods) request.getAttribute("goods");
		//获取交易数量
		String businessNum = request.getParameter("businessNum");
		//获取供货商ID
		String providerId = request.getParameter("providerId");
		//获取是否付款
		String isPayed = request.getParameter("isPayed");
		int count=acService.addAccount(goods, Integer.parseInt(businessNum), Integer.parseInt(providerId), Integer.parseInt(isPayed));
		if(count >0){
			//添加成功 重定向到表格页面
			response.sendRedirect("account?cmd=allAccount&p=1");
		}else{
			//添加失败
			PrintWriter out = response.getWriter();
			out.print("<script>alert('添加失败');</script>");
		}
		
	}

	private void allAccount(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PageBean pageBean=new PageBean();
		/**
		 * pagesize:5
		 * data:
		 * count：
		 * pagetotal
		 * p：
		 * */
		PageBean pageBean1 = new PageBean();
		//先获取count
		int count = cmService.getCount("tb_account", null, null);
		//设置count的值，同时也设置pagetotal的值
		pageBean1.setCount(count);
		//设置p的值
		String p = request.getParameter("p");

		if(p != null && p != ""){
			pageBean1.setP(Integer.parseInt(p));
		}else{
			pageBean1.setP(1);
		}
		/**
		 * 然后再去求当前页的数据结合
		 * */
		pageBean1 = acService.getPageBean(pageBean1);

		request.getSession().setAttribute("pageBean", pageBean1);

		if(p != null && p != ""){
			//
			PrintWriter out = response.getWriter();
			out.print("<script>top.location.href='jsp/admin_index.jsp'</script>");
		}else{
			//说明第一次进入
			response.sendRedirect("jsp/admin_index.jsp");
		}
//		/*
//		 * 1,设置count
//		 * 2,设置pagesize
//		 * 3,P
//		 */
//		pageBean.setCount(cmService.getCount("tb_account", null, null));
//		String p=request.getParameter("p");
//		if(p !=null && p != ""){
//			//有参数P
//			pageBean.setP(Integer.parseInt(p));
//		}else{
//			//没有参数P
//			pageBean.setP(1);
//		}
//		pageBean = acService.getPageBean(pageBean);
//		//保存数据到session
//		request.getSession().setAttribute("pageBean", pageBean);
//		if(p != null && p != ""){
//			PrintWriter out=response.getWriter();
//			out.print("<script>window.location.href='jsp/admin_bill_list.jsp'</script>");
//		}else{
//		//重定向到
//		response.sendRedirect("jsp/admin_index.jsp");
//		}
	}

}
