<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    
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
    <s:form action="" method="post">
    	<s:textfield label="用户名" name="user.uname" ></s:textfield>
    	<s:password label="密码" name="user.upwd"></s:password>
    	<s:checkbox label="学历" list="{'初中','','高中','大专','本科'}" size="1" value="{大专}" name="user.education" fieldValue="1" labelposition="left"></s:checkbox>
    	<s:radio label="性别" list="{1:男,0:女}" name="user.sex" value="0"></s:radio>
    	<s:submit value="注册"></s:submit>
    </s:form>
  </body>
</html>
