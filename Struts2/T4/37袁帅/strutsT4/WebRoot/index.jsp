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
   <s:form action="user" method="post">
     <s:textfield label="用户名:" name="user.name"/><br/>
     <s:password label="密码:" name="user.password"/><br/>
     <s:radio label="性别:" name="user.sex" list="#{'M':'男','F':'女'}" value="M"/><br/>  
     <s:checkbox label="爱好:" list="{'吃','喝','玩','睡'}" name="user.love" /><br/>	
     <s:select label="学历" list="{'小学','初中','高中','大学'}" size="1" value="小学" name="user.education"></s:select>
     <s:textfield label="手机号" name="user.telphone" required="true"/>
  	 <s:submit value="注册" />
</s:form>
  </body>
</html>
