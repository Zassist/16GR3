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
    <!-- 结合struts2标签保存数据到值栈中 -->
    <s:set name="uname" value="'qq'"></s:set>
    <br/>
    111111111
    <br/>
    <!-- 结合struts2标签从值栈中获取数据 -->
    <s:property value="#uname"/>
    <br/>
    <s:set name="books" value="{'sss','aaa','www',123456}"></s:set>
    <br/>
    <s:property value="#books[1]"/>
 <br>
 <br>
 <br>
   <form action="user" method="post">
   用户名：<input type="text" name="user.uanme"/><br>
    密码：<input type="password" name="user.upwd"/><br>
    年龄：<input type="text" name="user.age"/><br>
    生日：<input type="text" name="user.birthday"/><br>
    性别：<input type="text" name="user.sex"/><br>
    地址：<input type="text" name="user.address"/><br>
  手机号：<input type="text" name="user.telphone"/><br>
  <input type="submit" value="注册">
   </form> 
    
  </body>
</html>
