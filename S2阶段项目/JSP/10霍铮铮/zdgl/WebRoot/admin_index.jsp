<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>超市账单管理系统</title>
<link type="text/css" rel="stylesheet" href="/zdgl/css/style.css" />
</head>
<frameset rows="100,*" cols="*" frameborder="no" border="0" framespacing="0">
	<frame src="/zdgl/admin_top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" />
	<frameset cols="200,*" frameborder="no" border="0" framespacing="0">
		<frame src="/zdgl/admin_left.jsp" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" />
		<frame src="/zdgl/user/userServlet?action=all" name="mainFrame" id="mainFrame" />
	</frameset>
</frameset>
<noframes><body>
</body></noframes>
</html>
