<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
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
    <h2>用户信息</h2>
	<a href="jsp/addUser.jsp">添加用户</a>
	<table border="1px">
		<tr>
			<th>用户ID</th>
			<th>用户名</th>
			<th>密码</th>
			<th>生日</th>
			<th>性别</th>
			<th>是否启用</th>
			<th>操作</th>
		</tr>
		<s:iterator value="list" var="user">
			<tr>
				<td>${user.id }</td>
				<td>${user.uname }</td>
				<td>${user.upwd }</td>
				<td>${user.birthday }</td>
				<td><s:if test='#user.sex == "M"'>男</s:if> <s:else>女</s:else></td>
				<td><s:if test="#user.enable == 0">否</s:if><s:else>是</s:else></td>
				<td>
				<a href="toUpdateUser?user.id=${user.id }">修改</a> 
				<a href="deleteUser?user.id=${user.id }">删除</a></td>
			</tr>
		</s:iterator>
	</table>


  </body>
</html>
