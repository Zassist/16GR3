<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
	<s:set name="uname" value="'sacura'"></s:set><br> 
	---------------------------<br>
	<s:property value="uname"/>
	<form action="user" method="post">
		用户名:<input type="text" name="user.uname"><br>
		密码:<input type="password" name="user.upwd"><br>
		年龄:<input type="text" name="user.age"><br>
		性别:<input type="text" name="user.sex"><br>
		出生日期:<input type="text" name="user.brithday"><br>
		地址:<input type="text" name="user.address"><br>
		<input type="submit" value="注册">
	</form>
</body>
</html>