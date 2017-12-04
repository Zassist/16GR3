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
  <a href="jsp/addUser.jsp">添加新用户</a>
  <table border ="1">
  <tr>
  <td>用户ID</td><td>姓名</td><td>密码</td><td>性别</td><td>出生日期</td><td>是否启用</td>
  <td>操作</td>
  <s:iterator value="list" var="user" >
  <tr>
  	<td><s:property value="#user.id" /></td>
  	<td><s:property value="#user.uname" /></td>
  	<td><s:property value="#user.upwd" /></td>
  	<td><s:if test ='"M"'>男</s:if><s:else>女</s:else></td>
  	<td><s:property value="#user.birthday" /></td>
  	<td><s:property value="#user.enable" /></td>
  	<td><s:a href="/">修改</s:a></td>
  	<td><s:a href="del?user.id=${userbean.id }">删除</s:a></td>
	  </tr>
	  </s:iterator>
	  </tr>
	  </table>
	    </table>
  </body>
</html>
