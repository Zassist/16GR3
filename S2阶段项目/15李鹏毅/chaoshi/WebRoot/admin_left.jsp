<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body class="frame-bd">
<ul class="left-menu">
	<li><a href="admin_bill_list.jsp" target="mainFrame"><img src="images/btn_bill.gif" /></a></li>
	<li><a href="providerAdmin.jsp" target="mainFrame"><img src="images/btn_suppliers.gif" /></a></li>
	<li><a href="User?cmd=Userfenye" target="mainFrame"><img src="images/btn_users.gif" /></a></li>
	<li><a href="#" onClick="javaScript:alert('这里实现退出操作！')"><img src="images/btn_exit.gif" /></a></li>
</ul>
</body>
</html>
