package com.qhit.smb.User.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.smb.Account.service.Impl.AccountServiceImpl;
import com.qhit.smb.Provide.service.Impl.ProvideServiceImpl;
import com.qhit.smb.User.bean.User;
import com.qhit.smb.User.service.Impl.UserServiceImpl;
import com.qhit.smb.common.bean.PageBean;
import com.qhit.smb.common.service.impl.CommonServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(name = "user", urlPatterns = { "/user" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @throws IOException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cmd = request.getParameter("cmd");
		switch (cmd) {
		case "longi":
			// 登录认证
			Dolongin(request, response);
			break;
		case "exit":
			// 退出操作
			UserExit(request, response);
			break;
		case "register":
			// 添加新员工
			register(request, response);
			break;
		case "query":
			// 条件查询员工
			query(request, response);
			break;
		case "getPageBean":
			// 上（下）一页
			getPageBean(request, response);
			break;
		default:
			break;
		}
	}

	private void getPageBean(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PageBean pageBean = new PageBean();
		pageBean.setCount(new CommonServiceImpl().getCount("tb_user", null, null));
		pageBean.setP(Integer.valueOf(request.getParameter("p")));
		// 员工列表添加到会话域
		request.getSession().setAttribute("users", new UserServiceImpl().GetAllUser(pageBean));
		response.sendRedirect("jsp/admin_index.jsp");
	}

	/**
	 * 条件查询员工
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void query(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 获取查询条件
		String userName = request.getParameter("userName");
		// 创建分页对象
		PageBean pageBean = new PageBean();
		// 添加查询条件
		List<String> wheres = new ArrayList<>();
		wheres.add("userName");
		List<String> values = new ArrayList<>();
		values.add(userName);
		// 添加数据库中的记录数
		pageBean.setCount(new CommonServiceImpl().getCount("tb_user", wheres, values));
		// 设置当前页数
		pageBean.setP(0);
		// 添加分页员工列表实例
		pageBean = new UserServiceImpl().QueryUser(pageBean, userName);
		if (pageBean.getData() != null) {
			// 员工列表添加到会话域
			request.getSession().setAttribute("users", pageBean);
		} else {
			// 弹出错误提示
			response.getWriter().print("<script>alert('没有这个用户或用户名输入错误，请重新输入!')</script>");
			// 返回员工界面
			response.getWriter().print("<script>location.href='jsp/userAdmin.jsp'</script>");

		}
	}

	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 获取员工资料并实例化user对象
		User user = new User(request.getParameter("userName"), request.getParameter("userPassword"),
				request.getParameter("userSex"), Integer.valueOf(request.getParameter("userAge")),
				Integer.valueOf(request.getParameter("telephone")), request.getParameter("address"),
				request.getParameter("pic"), Integer.valueOf(request.getParameter("type")));
		if (new UserServiceImpl().register(user) != null) {
			// 添加员工成功，返回员工界面
			response.getWriter().print("<script>location.href='userAdmin.jsp'</script>");
		} else {
			// 添加员工失败，弹出错误提示
			response.getWriter().print("<script>alert('服务器异常请稍后重试!')</script>");
		}
	}

	private void UserExit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 清除会话域
		request.getSession().invalidate();
		// 获取项目名
		String path = request.getContextPath();
		// 获取项目的网络路径
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
				+ "/";
		// 跳转到登陆界面
		response.getWriter().print("<script>window.top.location.href='" + basePath + "'</script>");
	}

	private void Dolongin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		boolean is = true;
		// 获取用户名和密码
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		// 获取在线用户集合
		List<User> users = (List<User>) request.getServletContext().getAttribute("online");
		// 查找用户实例
		User user = new UserServiceImpl().Login(userName, userPassword);
		if (user != null) {
			// if(users != null) {
			for (User user2 : users) {
				// 遍历所有在线用户集合对比登陆用户是否存在
				if (user.getUserId() == user2.getUserId()) {
					is = false;
				}
				// }
			}
			if (is) {
				users.add(user);
				request.getServletContext().setAttribute("online", users);
			}
			// 用户实例添加到会话域
			request.getSession().setAttribute("user", user);
			// 添加分页对象的账单记录到会话域
			request.getSession().setAttribute("accountstal", new AccountServiceImpl().GetAllAccount(new PageBean()));
			// 员工列表添加到会话域
			request.getSession().setAttribute("users", new UserServiceImpl().GetAllUser(new PageBean()));
			// 供应商列表添加到会话域
			request.getSession().setAttribute("providers", new ProvideServiceImpl().GetAllProvider(new PageBean()));
			response.sendRedirect("jsp/admin_index.jsp");
		} else {
			response.sendRedirect("index.jsp?moder=error");
		}

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
