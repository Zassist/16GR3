package com.qhit.zdgl.account.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.SmartUpload;
import com.qhit.zdgl.account.bean.Account;
import com.qhit.zdgl.account.service.AccountService;
import com.qhit.zdgl.common.bean.PageBean;
import com.qhit.zdgl.user.bean.User;
import com.qhit.zdgl.user.service.UserService;

public class AccountServlet extends HttpServlet {
	private AccountService as = new AccountService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if(action.equals("sel")){
			sel(request,response);
		}else if(action.equals("del")){
			del(request,response);
		}else if(action.equals("add")){
			add(request,response);
		}else if(action.equals("preAdd")){
			preAdd(request,response);
		}else if(action.equals("preUpd")){
			preUpd(request,response);
		}else if(action.equals("upd")){
			upd(request,response);
		}
		
	}
	
	/**
	 * ��ѯ����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void sel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		int p = 1;
		String pNum = request.getParameter("p");
		if(pNum!=null){
			p = Integer.parseInt(pNum);
		}
		String goodsName = request.getParameter("goodsName");
		String isPayed = request.getParameter("isPayed");
		Map map = new HashMap();
		map.put("p", p);
		map.put("goodsName",goodsName);
		map.put("isPayed",isPayed);
		PageBean pb = as.selAccount(map);
		request.setAttribute("pageBean", pb);
		request.getRequestDispatcher("/admin_bill_list.jsp").forward(request, response);
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
		int accountId = Integer.parseInt(request.getParameter("accountId"));
		int count = as.delAccount(accountId);
		if(count == 1){
			request.setAttribute("message", "ɾ���ɹ�!");
		}else{
			request.setAttribute("message", "ɾ��ʧ��!");
		}
		sel(request,response);
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
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		int businessNum = Integer.parseInt(request.getParameter("businessNum"));
		double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
		int isPayed = Integer.parseInt(request.getParameter("isPayed"));
		int providerId = Integer.parseInt(request.getParameter("providerId"));
		String accountDate = request.getParameter("accountDate");
		Account account = new Account(providerId, totalPrice, isPayed, accountDate, goodsId, businessNum);
		int count = as.addAccount(account);
		if(count == 1){
			request.setAttribute("message", "��ӳɹ�!");
			response.sendRedirect("/zdgl/account/accountServlet?action=sel");
		}else{
			request.setAttribute("message", "���ʧ��!");
			preAdd(request,response);
		}
		
	}
	/**
	* Ԥ���
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void preAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
			Map map = as.preAdd();
			request.setAttribute("goods", map.get("goods"));
			request.setAttribute("providers", map.get("providers"));
			request.getRequestDispatcher("/billAdd.jsp").forward(request, response);
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
			int accountId = Integer.parseInt(request.getParameter("accountId"));
			Account account = as.preUpd(accountId);
			if(account!=null){
				Map map = as.preAdd();
				request.setAttribute("goods", map.get("goods"));
				request.setAttribute("providers", map.get("providers"));
				request.setAttribute("account", account);
				request.getRequestDispatcher("/billAdd.jsp").forward(request, response);
			}else{
				request.setAttribute("message", "�������쳣!");
				sel(request,response);
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
		int accountId = Integer.parseInt(request.getParameter("accountId"));
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		int businessNum = Integer.parseInt(request.getParameter("businessNum"));
		double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
		int isPayed = Integer.parseInt(request.getParameter("isPayed"));
		int providerId = Integer.parseInt(request.getParameter("providerId"));
		String accountDate = request.getParameter("accountDate");
		Account account = new Account(accountId,providerId, totalPrice, isPayed, accountDate, goodsId, businessNum);
		int count = as.updAccount(account);
		if(count == 1){
			request.setAttribute("message", "�޸ĳɹ�!");
			response.sendRedirect("/zdgl/account/accountServlet?action=sel");
		}else{
			request.setAttribute("message", "�޸�ʧ��!");
			preAdd(request,response);
		}
		
	}
}
