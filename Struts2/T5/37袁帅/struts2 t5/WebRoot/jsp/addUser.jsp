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
    <div class="wrap">
		<table border="1px">
		<s:form action="addUser" method="post">
			<s:textfield label="用户名" name="user.uname" required="true" ></s:textfield>
			<s:password label="密码" name="user.upwd" required="true"></s:password>
			<s:textfield label="生日" name="user.birthday" required="true"></s:textfield>
			<s:radio label="性别" name="user.sex" list="#{'M':'男','F':'女' }" value='"M"'></s:radio>
			<s:select label="是否启用" name="user.enable" list="#{1:'是',0:'否' }" value="0" ></s:select>
			<s:submit value="注册"></s:submit>
		</s:form>
		</table>
	</div>
  </body>
</html>
