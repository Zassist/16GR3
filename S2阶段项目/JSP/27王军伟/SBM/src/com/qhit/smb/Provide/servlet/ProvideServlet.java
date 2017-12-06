package com.qhit.smb.Provide.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.smb.Provide.service.Impl.ProvideServiceImpl;
import com.qhit.smb.common.bean.PageBean;
import com.qhit.smb.common.service.impl.CommonServiceImpl;

/**
 * Servlet implementation class ProvideServlet
 */
@WebServlet(name = "provide", urlPatterns = { "/provide" })
public class ProvideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		switch (request.getParameter("cmd")) {
		case "query":
			query(request, response);
			break;

		default:
			break;
		}
	}

	private void query(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String providername = request.getParameter("providername");
		String providerdetail = request.getParameter("providerdetail");
		// 获取条件参数查找并添加到会话域
		PageBean pageBean = new PageBean();
		List<String> wheres = new ArrayList<>();
		wheres.add("providername");
		wheres.add("providerdetail");
		List<String> values = new ArrayList<>();
		values.add(providername);
		values.add(providerdetail);
		pageBean.setCount(new CommonServiceImpl().getCount("tb_provider", wheres, values));
		request.getSession().setAttribute("providers",
				new ProvideServiceImpl().QueryProvider(pageBean, providername, providerdetail));
		// 返回到界面
		response.getWriter().print("<script>window.location.href='jsp/providerAdmin.jsp'</script>");
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
