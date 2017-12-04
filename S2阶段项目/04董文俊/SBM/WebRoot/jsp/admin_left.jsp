<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body class="frame-bd">
<ul class="left-menu">
	<li><a href="account?cmd=allAccount&p=1" target="mainFrame"><img src="images/btn_bill.gif" /></a></li>
		
		<c:if test="${user.type == 0}">
			<li><a href="provider?cmd=allProvider&p=1" target="mainFrame"><img src="images/btn_suppliers.gif" /></a></li>
			<li><a href="user?cmd=allUser" target="mainFrame"><img src="images/btn_users.gif" /></a></li>
		</c:if>
	
	
	<li><a href="user?cmd=doExit"><img src="images/btn_exit.gif" /></a></li>
</ul>
</body>
</html>
