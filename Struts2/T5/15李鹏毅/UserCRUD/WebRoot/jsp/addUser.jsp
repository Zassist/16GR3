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
    
    <title>My JSP 'addUser.jsp' starting page</title>
    
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
   <s:form action="user!add" method="post" namespace="/">
   		<s:textfield label="姓名" required="true" name="userbean.uname"> </s:textfield>
   		<s:password label="密码" required="true" name="userbean.upwd"></s:password>
   		<s:radio label="性别" list="#{'1':'男','2':'女'}" required="true" name="userbean.sex"></s:radio>
   		<s:textfield label="生日" name="userbean.birthday"></s:textfield>
   		<s:radio label="启用" list="#{'0':'是','1':'否'}" required="true"  name="userbean.enable"></s:radio>
   		<s:submit value="添加"></s:submit>
   </s:form>
   
  </body>
</html>
