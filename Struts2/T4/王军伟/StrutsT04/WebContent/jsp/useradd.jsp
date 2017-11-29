<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
</head>
<body>
	<center>
		<s:form action="/user!useradd" method="post" theme="simple">
		用户名：<s:textfield name="user.name"></s:textfield>
			<br>
	密码：<s:textfield name="user.password"></s:textfield>
			<br>
	性别：<s:radio name="user.sex" list="#{1:'男',0:'女'}" value="1"></s:radio>
			<br>
	学历：<s:checkboxlist list="#{'小学','初中','高中','大学','研究生'}"></s:checkboxlist>
			<br>
			<input type="submit" value="提交">
		</s:form>
	</center>
</body>
</html>