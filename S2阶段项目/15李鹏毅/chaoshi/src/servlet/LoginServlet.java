package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LoginServiceI;
import service.LoginServiceIMP;
import bean.PageBean;
import bean.User;



public class LoginServlet extends HttpServlet {
	
	LoginServiceI Service=new LoginServiceIMP();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd=request.getParameter("cmd");
		if(cmd.equals("login")){
			login(request, response);
		}else if(cmd.equals("fenyechaxun")){
			fenyechaxun(request, response);
		}else if(cmd.equals("zhangdanchaxun")){
			zhangdanchaxun(request, response);
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("userName");
		String passWord=request.getParameter("passWord");
		User user=Service.login(userName, passWord);
		
		if(user==null){
			System.out.println("登陆失败");
		}else{
			request.getSession().setAttribute("user", user);//把当前用户放到作用域
			try {

				response.sendRedirect("login?cmd=fenyechaxun");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	public void fenyechaxun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int up =1; //首次登陆，默认显示
		String uid=((User)request.getSession().getAttribute("user")).getUserId();//获取userid
		PageBean pageBean=Service.fenyechaxun(uid, up);

		request.getSession().setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("admin_index.jsp").forward(request, response);
		
		}
	public void zhangdanchaxun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int up =1; //首次登陆，默认显示
		String ps = request.getParameter("p");
		if(ps!=null){
			up = Integer.parseInt(ps);
		}
		String uid=((User)request.getSession().getAttribute("user")).getUserId();//获取userid
		PageBean pageBean=Service.fenyechaxun(uid, up);

		request.getSession().setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("admin_bill_list.jsp").forward(request, response);
		
		}
	
	


}
