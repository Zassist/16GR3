<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<% String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
   <form action="user" method="post">
   
   <center><br><br><br>
   		用&nbsp;户&nbsp;名 :<input type="text" name="userbean.uname"><br><br>
   		密&nbsp; &nbsp;码:<input type="password" name="userbean.upwd"><br><br>
   		性 &nbsp;&nbsp;别:<input type="text" name="userbean.sex"><br><br>
   		生 &nbsp;&nbsp;日:<input type="text" name="userbean.birthday"><br><br>
   		联&nbsp;系&nbsp;电&nbsp;话:<input type="text" name="userbean.telephone"><br><br>
   <input type="submit" value="注册">
   </center>
   </form>
  </body>
</html>
