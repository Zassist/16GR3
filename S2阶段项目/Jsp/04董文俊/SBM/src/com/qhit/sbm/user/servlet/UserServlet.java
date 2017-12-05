package com.qhit.sbm.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.common.service.CommonService;
import com.qhit.sbm.common.service.impl.CommonServiceImpl;
import com.qhit.sbm.user.bean.User;
import com.qhit.sbm.user.service.UserService;
import com.qhit.sbm.user.service.impl.UserServiceImpl;
import com.qhit.sbm.utils.CommonUtil;
import com.qhit.sbm.utils.IDUtil;

public class UserServlet extends HttpServlet {
	private UserService usService=new UserServiceImpl();
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
			
			case "doLogin"://登录方法
				doLogin(request,response);
				break;
			case "doExit"://退出方法
				doExit(request,response);
				break;
			case "allUser"://获取方法
				allUser(request,response);
				break;
			case "addUser"://添加方法
				addUser(request,response);
				break;
			case "delUser"://删除方法
				delUser(request,response);
				break;
			case "uploadPic":
				uploadPic(request, response);
				break;
			default:
				break;
			}
	}
	//头像
	private void uploadPic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//声明并初始化
		SmartUpload smartUpload=new SmartUpload();
		smartUpload.initialize(getServletConfig(),request,response);
		//设置上传格式
		smartUpload.setAllowedFilesList("png,jpg,JPEG,gif");
		//设置上传文件大小
		smartUpload.setMaxFileSize(1024*1024*5);
		PrintWriter out = response.getWriter();
		String realPath =  request.getRealPath("/")+"/";//项目路径
		String filePath = CommonUtil.FILE_USER_PIC_PHOTO_PATH;
		java.io.File file = new java.io.File(realPath+filePath);
		if(!file.exists()){
			file.mkdirs();
		}
		//图片保存的名称
		String picName = IDUtil.getUUID();
		System.out.println(picName);
		//图片的后缀名
		File picFile = smartUpload.getFiles().getFile(0);
		String picFileExt = picFile.getFileExt();
		//最终获取到的文件相对路径
		String picPath = filePath+picName+"."+picFileExt;
		//保存文件
		try {
			picFile.saveAs(realPath+picPath);
		} catch (SmartUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//头像上传成功，之后根据表单提交的数据和获取头像图片的存储路径插入数据表中：因为需要之前表单的所有的数据所以需要用到请求转发
		//添加用户头像的路径到request对象中，转发出去
		
		com.jspsmart.upload.Request sRequest = smartUpload.getRequest();
		
		request.setAttribute("userName", sRequest.getParameter("userName"));
		request.setAttribute("userPassword", sRequest.getParameter("userPassword"));
		request.setAttribute("userSex", sRequest.getParameter("userSex"));
		request.setAttribute("userAge", sRequest.getParameter("userAge"));
		request.setAttribute("telephone", sRequest.getParameter("telephone"));
		request.setAttribute("address", sRequest.getParameter("address"));
		request.setAttribute("type", sRequest.getParameter("type"));
		request.setAttribute("pic", picPath);
		RequestDispatcher rDispatcher = request.getRequestDispatcher("user?cmd=addUser");
		rDispatcher.forward(request, response);
		try {
			smartUpload.upload();
		}catch (SmartUploadException e) {
			//异常处理
			out.print("<script>alert('上传头像失败，请检查图片格式和大小');</script>");
		}
	}

	private void delUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String userId=request.getParameter("userId");
		int count =usService.delUser(Integer.parseInt(userId));
		if(count >0){
			//删除成功 重定向到表格页面
			response.sendRedirect("user?cmd=allUser&p=1");
		}else{
			//删除失败
			PrintWriter out = response.getWriter();
			out.print("<script>alert('删除失败');</script>");
		}
		
	}

	private void allUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PageBean pageBean=new PageBean();
		/*
		 * 1,设置count
		 * 2,设置pagesize
		 * 3,P
		 */
		pageBean.setCount(cmService.getCount("tb_user", null, null));
		String p=request.getParameter("p");
		if(p !=null && p != ""){
			//有参数P
			pageBean.setP(Integer.parseInt(p));
		}else{
			//没有参数P
			pageBean.setP(1);
		}
		pageBean = usService.getPageBean(pageBean);
		//保存数据到session
		request.getSession().setAttribute("pageBean", pageBean);
		if(p != null && p != ""){
			PrintWriter out=response.getWriter();
			out.print("<script>location.href='jsp/userAdmin'</script>");
		}else{
		//重定向到
		response.sendRedirect("jsp/userAdmin.jsp");
		}
	}

	private void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//获取参数
		String userName = (String)request.getAttribute("userName");
		String userPassword = (String)request.getAttribute("userPassword");
		String userSex = (String)request.getAttribute("userSex");
		String userAge = (String)request.getAttribute("userAge");
		String telephone = (String)request.getAttribute("telephone");
		String address = (String)request.getAttribute("address");
		String type = (String)request.getAttribute("type");
		String pic = (String) request.getAttribute("pic");
		User user = new User(
				userName, 
				userPassword, 
				userSex, 
				Integer.parseInt(userAge), 
				telephone, 
				address,
				pic, 
				Integer.parseInt(type)
				);
		//调用添加方法
		PrintWriter out = response.getWriter();
		int count=usService.addUser(user);
		if(count > 0){
			//添加成功,重定向到用户列表页面
			response.sendRedirect("user?cmd=allUser&p=1");
		}else{
			//添加失败
			out.print("<script>alert('添加失败');</script>");
		}
	}

	private void doExit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
		PrintWriter out=response.getWriter();
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		out.print("<script>window.top.location.href='"+basePath+"'</script>");
		
	}

	private void doLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String userName=request.getParameter("userName");
		String userPassword=request.getParameter("userPassword");
		User user=usService.doLogin(userName, userPassword);
		if(user != null){
			boolean isOnline = false;
			request.getSession().setAttribute("user", user);
			List<User> users =(List<User>) request.getServletContext().getAttribute("onlines");
					for (User user2 : users) {
						if(user2.getUserId() == user.getUserId()){
							isOnline=true;
							break;
						}
					}
				if(isOnline == true){
					//已经登录，直接跳转
					response.sendRedirect("account?cmd=allAccount");
				}else{
					//如果未登录则添加到在线列表当中
					users.add(user);
					request.getServletContext().setAttribute("onlines", users);
					//跳转页面
					response.sendRedirect("account?cmd=allAccount");
				}
		}else{
			//登录失败
			response.sendRedirect("index.jsp?login=not");
		}
//		if(user != null){
//			//登陆成功
//			//放入session对象当中
//			request.getSession().setAttribute("user", user);
//			//获取在线列表集合
//			List<User> onlines=(List<User>) request.getServletContext().getAttribute("onlines");
//			onlines.add(user);
//			request.getServletContext().setAttribute("onlines", onlines);
//			//跳转页面
//			response.sendRedirect("jsp/admin_index.jsp");
//		}else{
//			//登录失败
//			response.sendRedirect("index.jsp?login=not");
//		}
		
	}



}
