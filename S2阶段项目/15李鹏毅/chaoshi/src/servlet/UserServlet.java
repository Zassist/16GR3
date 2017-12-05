package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LoginServiceI;
import service.LoginServiceIMP;
import bean.PageBean;
import bean.User;

public class UserServlet extends HttpServlet {

	LoginServiceI Service=new LoginServiceIMP();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd=request.getParameter("cmd");
		if(cmd.equals("Userfenye")){
			Userfenye(request, response);
		}
		
	}
	public void Userfenye(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int up =1; //首次登陆，默认显示
		String ps = request.getParameter("p");
		if(ps!=null){
			up = Integer.parseInt(ps);
		}
//		String uid=((User)request.getSession().getAttribute("user")).getUserId();//获取userid
		PageBean pageBean=Service.Userchaxun(up);

		request.getSession().setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("userAdmin.jsp").forward(request, response);
	}

}
