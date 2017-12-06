<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
  <s:set name="uname" value="'zhangpan'"></s:set>
    <s:property value="#uname"/>
   <br />
   <form action="user" method="post">
       用户名：<input type="text" name="uesr.uname"/> <br />
      密码：<input type="password" name="uesr.upwd"/> <br />     
      年龄：<input type="text" name="uesr.age"/> <br />   
      性别：<input type="text" name="uesr.sex"/> <br />  
      地址：<input type="text" name="uesr.address"/> <br />
      手机号：<input type="text" name="uesr.telphone"/> <br />
      <input type="submit" value="注册"/>   
   </form>
  </body>
</html>
