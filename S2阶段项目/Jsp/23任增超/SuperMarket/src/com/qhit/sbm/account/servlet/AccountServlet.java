package com.qhit.sbm.account.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.sbm.account.service.AccountService;
import com.qhit.sbm.account.service.impl.AccountServiceImpl;
import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.common.service.CommonService;
import com.qhit.sbm.common.service.impl.CommonServiceIpml;
import com.qhit.sbm.goods.bean.Goods;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommonService commonService = new CommonServiceIpml();
	private AccountService accountService = new AccountServiceImpl();
       


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
		case "getPageBean":
			getPageBean(request, response);
			break;
		case "addAccount":
			addAccount(request, response);
			break;
		case "getAccountByParam":
			getAccountByParam(request, response);
			break;
		case "delAccount":
			delAccount(request, response);
			break;
		case "updAccount":
			updAccount(request, response);
			break;
		default:
			break;
		}
	}
	
	
	private void getAccountByParam(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String goodsName = request.getParameter("goodsName");
		String isPayed = request.getParameter("isPayed");
		List<String> wheres = new ArrayList<>();
		List<String> values = new ArrayList<>();
		if(goodsName != null && goodsName != ""){
			wheres.add("g.goodsName");
			values.add(goodsName);
		}
		if(isPayed != null && isPayed != ""){
			wheres.add("a.isPayed");
			values.add(isPayed);
		}
		
		PageBean pageBean = accountService.getPageBeanByParam(wheres, values);
		
		request.getSession().setAttribute("pageBean", pageBean);
		
		PrintWriter out = response.getWriter();
		out.print("<script>location.href = 'jsp/admin_bill_list.jsp'</script>");
		
	}

	/**
	 * @param request
	 * @param response
	 * 更新
	 * @throws IOException 
	 */
	private void updAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String accountId = request.getParameter("accountId");
		String providerId = request.getParameter("providerId");
		String isPayed = request.getParameter("isPayed");
		
		int row = accountService.updAccountById(
				Integer.parseInt(accountId), 
				Integer.parseInt(providerId), 
				Integer.parseInt(isPayed));
		if(row > 0){
			//更新成功
			response.sendRedirect("AccountServlet?cmd=getPageBean&&p=1");
		}else{
			//更新失败
			PrintWriter out = response.getWriter();
			out.print("<script>alert('更新失败');</script>");
		}
	}
	/**
	 * @param request
	 * @param response
	 * 添加
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void addAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Goods goods = (Goods) request.getAttribute("goods");
		String businessNum = request.getParameter("businessNum");
		String providerId = request.getParameter("providerId");
		String isPayed = request.getParameter("isPayed");
		int row = accountService.addAccount(goods, 
				Integer.parseInt(businessNum), 
				Integer.parseInt(providerId), 
				Integer.parseInt(isPayed));

		if(row > 0){
			//更新库存
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("goods?cmd=updateStore");
			requestDispatcher.forward(request, response);
		}else{
			//添加失败
			PrintWriter out = response.getWriter();
			out.print("<script>alert('添加失败');</script>");
		}
	}
	
	/**
	 * @param request
	 * @param response
	 * 删除
	 * @throws IOException 
	 */
	private void delAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String accountId = request.getParameter("accountId");
		int row = accountService.delAccount(Integer.parseInt(accountId));
		if(row > 0){
			//删除成功
			response.sendRedirect("AccountServlet?cmd=getPageBean&&p=1");
		}else{
			//删除失败
			PrintWriter out = response.getWriter();
			out.print("<script>alert('删除失败');</script>");
		}
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void getPageBean(HttpServletRequest request, HttpServletResponse response) throws IOException {

		PageBean pageBean = new PageBean();
		int count = commonService.getCount("tb_account", null, null);
		pageBean.setCount(count);
		
		String p = request.getParameter("p");
		if(p != null && p != ""){
			//有参数p
			pageBean.setP(Integer.parseInt(p));
		}else{
			//没有参数，第一次进入
			pageBean.setP(1);
		}
		
		pageBean = accountService.getPageBean(pageBean);
		System.out.println(pageBean.getData().size());
		request.getSession().setAttribute("pageBean", pageBean);
		if(p != null && p != ""){
			//有参数p
			PrintWriter out = response.getWriter();
			out.print("<script>location.href = 'jsp/admin_bill_list.jsp'</script>");
		}else{
			response.sendRedirect("jsp/admin_index.jsp");
		}
		
	
	}

}
