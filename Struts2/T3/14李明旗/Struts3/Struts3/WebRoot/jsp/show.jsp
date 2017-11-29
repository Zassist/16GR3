<%@page import="javax.servlet.jsp.tagext.TagFileInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'show.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <body>
  <center ><br><br><br>
  	你好:<s:property value="userbean.uname"/><br><br>
 		您的密码:<s:property value="userbean.upwd"/><br><br>
 		性别:	<s:property value="userbean.sex"/><br><br>
 		生日:<s:property value="userbean.birthday"/><br><br>
 		联系电话:<s:property value="userbean.telephone"/>
 		</center>
 	
  </body>
</html>
