<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:form action="user" method="post">
		<s:textfield label="用户名:" name="user.uname"></s:textfield>
		<s:password label="密码:" name="user.upwd"></s:password>
		<s:radio label="性别" name="user.sex" list="#{1:'男',0:'女' }" value="1"></s:radio>
		<s:select label="学历" name="user.edu" list="{'初中','高中','大学'}"></s:select>
		<s:submit value="注册"></s:submit>
	</s:form>
</body>
</html>