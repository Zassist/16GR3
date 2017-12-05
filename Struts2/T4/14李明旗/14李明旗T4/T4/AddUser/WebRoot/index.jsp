<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
  <s:form action="userbean" method="post">
	<s:textfield label="姓名" name="userbean.uname"></s:textfield>
    <s:password label="密码" name="userbean.upwd"></s:password>
    <s:radio label="性别" list="#{'1':'男','0':'女' }" name="userbean.sex"></s:radio>
    <s:select label="学历" list="{'初中','高中','大专','本科','研究生'}"  name="userbean.edc"></s:select>
    <s:textfield label="电话" name="userbean.telephone"></s:textfield>
    <s:submit label="注册"></s:submit>
  </s:form>
  </body>
</html>
