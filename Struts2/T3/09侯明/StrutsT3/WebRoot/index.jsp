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
     	<s:set name="name" value="'hm'"></s:set>
    	<s:property value="#name"/>
    <br/>
    <form action="user" method="post">
    	姓名：<input type="text" name="user.name" /> <br />
    	密码：<input type="password" name="user.pwd" /> <br />
    	性别：<input type="text" name="user.sex" /> <br />
    	年龄：<input type="text" name="user.age" /> <br />
    	生日：<input type="text" name="user.birthday" /> <br />
    	<input type="submit" value="提交"/>
    </form>
  </body>
</html>
