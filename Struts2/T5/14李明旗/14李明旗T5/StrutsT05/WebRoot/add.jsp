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
  
  <body >
  <center>
  <h1>注册页面</h1>
    <s:form action="addUser"  method="post">
    <s:textfield label="用户名" name="user.uname" required="true"></s:textfield>
    <s:password label="密码" name="user.upwd" required="true"></s:password>
    <s:select list="{16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,
    31,32,33,34,35,36,37,37,38,40,41,42,43,44,45,46,47,48,49,50,
    51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,
    71,72,73,74,75,76,77,78,79,80,81,82,83,84,75,86,87,88,89,90,
    91,92,93,94,95,96,97,98,99}" label="年龄" name="user.age"></s:select>
    <s:radio list="#{'男':'男','女':'女'}" label="性别" value="'男'" name="user.sex"></s:radio>
    <s:select list="{'初中','高中','大专','本科','没上过学'}" label="学历" name="user.edu"></s:select>
    <s:textfield label="住址" name="user.address" required="true"></s:textfield>
    <s:textfield label="电话" name="user.tel" required="true"></s:textfield>
    <s:submit value="注册"></s:submit>
    </s:form>
    </center>
  </body>
</html>
