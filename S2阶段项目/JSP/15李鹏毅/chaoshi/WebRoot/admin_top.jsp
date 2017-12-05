<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="bean.User" %>
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
<body>
<div id="header">
	<div class="title"></div>
	<%String name =((User)request.getSession().getAttribute("user")).getUserName(); 
	
	%>
	<div class="welcome">欢迎您：<%=name %></div>
</div>
</body>
</html>
