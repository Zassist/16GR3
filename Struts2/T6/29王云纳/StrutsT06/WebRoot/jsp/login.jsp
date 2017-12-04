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
    
   
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<title><s:text name="login.title"></s:text> </title>
</head>
<body>
<%-- <s:fielderror/> --%>
<s:form action="loginUser" method="post">
	<s:textfield key="lable.uname" name="user.uname" required="true"/>
	<s:password key="lable.password" name="user.upwd" required="true"/>
	<s:submit key="lable.login"/>
</s:form>

<s:url id="localeEN" namespace="/" action="local" >
   <s:param name="request_locale" >en_US</s:param>
</s:url>
<s:url id="localezhCN" namespace="/" action="local" >
   <s:param name="request_locale" >zh_CN</s:param>
</s:url>
<s:a href="%{localeEN}" >English</s:a>
<s:a href="%{localezhCN}" >中文</s:a>
</body>
</html>