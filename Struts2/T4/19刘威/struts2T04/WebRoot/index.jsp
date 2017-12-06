<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
  	<center>
  	<s:form action="user" method="post">
  		<s:textfield label="账号" name="user.uname" required="true"/>
  		<s:password label="密码" name="user.pwd" required="true"/>
  		<s:radio label="性别" list="#{1:'男',2:'女' }" value="1" name="user.sex" />
  		<s:checkboxlist label="爱好" list="{'吃','喝','玩','乐'}" name="user.like"/>
  		<s:select label="学历" list="{'小学','初中','高中','大学'}" size="1" value="小学" name="user.education"></s:select>
  		<s:textfield label="手机号" name="user.telphone" required="true"/>
  		<s:submit value="注册" />
  	</s:form>
  	</center>
  </body>
</html>
