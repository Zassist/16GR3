package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.tb_account;
import service.LoginServiceI;
import service.LoginServiceIMP;

public class ZhangdanServlet extends HttpServlet {
	LoginServiceI Service=new LoginServiceIMP();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd=request.getParameter("cmd");
		if(cmd.equals("tianjia")){
			tianjia(request, response);
		}else if(cmd.equals("xiugai")){
			xiugai(request, response);
		}
		
	}
	public void tianjia (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String goodsName=request.getParameter("goodsName");
		String businessNum=request.getParameter("businessNum");
		String totalPrice=request.getParameter("totalPrice");
		String providerName=request.getParameter("providerName");
		String accountDate=request.getParameter("accountDate");
		String isPayed=request.getParameter("isPayed");
		
		int providerId=Service.gongyingshang(providerName);//获取供应商Id
		int goodsId=Service.shangpin(goodsName);//获取商品ID
		tb_account tb_account=new tb_account();
		tb_account.setGoodsId(goodsId);
		tb_account.setBusinessNum(Integer.parseInt(businessNum));
		tb_account.setTotalPrice(Integer.parseInt(totalPrice));
		tb_account.setProviderId(providerId);
		tb_account.setAccountDate(tb_account.getAccountDate());
		tb_account.setIsPayed(Integer.parseInt(isPayed));
		int i=Service.tianjiazhangdan(tb_account);
		if(i==1){
			response.sendRedirect("login?cmd=zhangdanchaxun");  
		}else {
			System.out.println("失败");
		}
		
		
		
		
		
	}
	public void xiugai(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bianhao=request.getParameter("bianhao");
		String goodsName =request.getParameter("goodsName");
		String businessNum =request.getParameter("businessNum");
		String totalPrice =request.getParameter("totalPrice");
		String providerName =request.getParameter("providerName");
		String accountDate =request.getParameter("accountDate");
		String isPayed =request.getParameter("isPayed");
		int providerId=Service.gongyingshang(providerName);//获取供应商Id
		int goodsId=Service.shangpin(goodsName);//获取商品ID
		tb_account tb_account=new tb_account();
		tb_account.setAccountId(Integer.parseInt(bianhao));
		tb_account.setGoodsName(goodsName);
		tb_account.setBusinessNum(Integer.parseInt(businessNum));
		tb_account.setTotalPrice(Integer.parseInt(totalPrice));
		tb_account.setProviderName(providerName);
		tb_account.setAccountDate(tb_account.getAccountDate());
		tb_account.setIsPayed(Integer.parseInt(isPayed));
		tb_account.setGoodsId(goodsId);
		tb_account.setProviderId(providerId);
		int i=Service.xiugaizhangdan(tb_account);
		if(i==1){
			System.out.println("成功");
			
			
		}
		
	}

	
	

}
