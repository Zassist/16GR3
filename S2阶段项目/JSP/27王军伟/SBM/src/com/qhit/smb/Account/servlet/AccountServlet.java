package com.qhit.smb.Account.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.smb.Account.bean.AccountDetail;
import com.qhit.smb.Account.service.Impl.AccountServiceImpl;
import com.qhit.smb.common.bean.PageBean;
import com.qhit.smb.common.dao.impl.CommonDaoImpl;
import com.qhit.smb.common.service.impl.CommonServiceImpl;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet(name = "account", urlPatterns = { "/account" })
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		switch (request.getParameter("cmd")) {
		case "query":
			// 条件查询
			query(request, response);
			break;
		case "addaccount":
			// 添加账单
			addaccount(request, response);
			break;
		case "getPageBean":
			// 上（下）一页
			getPageBean(request, response);
			break;
		case "deleteAccount":
			// 删除账单
			deleteAccount(request, response);
			break;
		case "updateAccount":
			// 修改账单
			updateAccount(request, response);
			break;
		default:
			break;
		}
	}

	private void updateAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		AccountDetail accountDetail = new AccountDetail(Integer.valueOf(request.getParameter("accountid")),
				request.getParameter("goodsName"), Integer.valueOf(request.getParameter("businessNum")), 0,
				Integer.valueOf(request.getParameter("isPayed")), null, request.getParameter("providerId"), null);
		int count = new AccountServiceImpl().updateAccount(accountDetail);
		if(count == 1) {
			response.getWriter().print("<script>alert('修改成功!')</script>");
			response.getWriter().print("<script>location.href='jsp/admin_bill_list.jsp'</script>");
		}else {
			response.getWriter().print("<script>alert('服务器异常请稍后重试!')</script>");
		}
	}

	private void deleteAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String accountId = request.getParameter("accountId");
		int count = new AccountServiceImpl().deleteAccount(accountId);
		if (count == 1) {
			response.getWriter().print("<script>alert('删除成功!')</script>");
			response.getWriter().print("<script>location.href='jsp/admin_bill_list.jsp'</script>");
		} else {
			response.getWriter().print("<script>alert('服务器异常请稍后重试!')</script>");
		}
	}

	/**
	 * 上（下）一页
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void getPageBean(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 创建分页对象
		PageBean pageBean = new PageBean();
		// 传入数据库记录的数量
		pageBean.setCount(new CommonDaoImpl().getCount("tb_account", null, null));
		// 传入当前的页数
		pageBean.setP(Integer.valueOf(request.getParameter("p")));
		// 添加分页对象的账单记录到会话域
		request.getSession().setAttribute("accountstal", new AccountServiceImpl().GetAllAccount(pageBean));
		// 返回到界面
		response.getWriter().print("<script>location.href='jsp/admin_bill_list.jsp'</script>");

	}

	/**
	 * 添加账单
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void addaccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 获取账单参数添加账单，返回受影响的行数
		int count = new AccountServiceImpl()
				.AddAccount(new AccountDetail(Integer.valueOf(request.getParameter("providerId")),
						request.getParameter("goodsName"), Integer.valueOf(request.getParameter("businessNum")),
						Integer.valueOf(request.getParameter("isPayed"))));
		if (count == 1) {
			// 账单添加到会话域
			PageBean pageBean = new PageBean();
			// 传入数据库记录的数量
			pageBean.setCount(new CommonDaoImpl().getCount("tb_account", null, null));
			// 添加分页对象的账单记录到会话域
			request.getSession().setAttribute("accountstal",
					new AccountServiceImpl().GetAllAccount(pageBean).getData());
			// 返回界面
			response.getWriter().print("<script>location.href='jsp/admin_bill_list.jsp'</script>");
		} else {
			// 账单添加失败
			response.getWriter().print("<script>alert('服务器异常请稍后重试!')</script>");
		}
	}

	/**
	 * 条件查询
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void query(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 获取查询条件
		String goodsName = request.getParameter("goodsName");
		String isPayed = request.getParameter("isPayed");
		// 创建条件名称
		List<String> wheres = new ArrayList<>();
		wheres.add("goodsName");
		wheres.add("isPayed");
		// 创建条件值
		List<String> volues = new ArrayList<>();
		volues.add(goodsName);
		volues.add(isPayed);
		// 创建分页对象
		PageBean pageBean = new PageBean();
		// 传入数据库记录的数量
		pageBean.setCount(new CommonServiceImpl().getCount("tb_account", wheres, volues));
		// 添加分页对象的账单记录到会话域
		request.getSession().setAttribute("accountstal",
				new AccountServiceImpl().GetConditionAccount(pageBean, goodsName, isPayed));
		// 返回到界面
		response.getWriter().print("<script>window.location.href='jsp/admin_bill_list.jsp'</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
