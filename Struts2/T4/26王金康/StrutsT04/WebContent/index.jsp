<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:form action="user" method="post">
		<s:textfield label="用户名" name="user.uname" required="true"></s:textfield>
		<s:password label="密码" name="user.password" required="true"></s:password>
		<s:radio label="性别" list="#{'M':'男','F':'女' }" value="'M'" name="user.sex" required="true"></s:radio>
		<s:select label="学历" list="{'高中','本科','研究生','博士'}" size="1" name="user.education"  value="高中" required="true"></s:select>
		<s:submit value="注册"></s:submit>
	</s:form>
</body>
</html>