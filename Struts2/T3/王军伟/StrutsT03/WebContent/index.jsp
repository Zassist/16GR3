<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>界面</title>
</head>
<body>
	<div align="center">
		<form action="ulogin" method="post">
			用户名： <input type="text" name="user.uname"> <br> 密码： <input
				type="password" name="user.uwpd"> <br> 年龄： <input
				type="text" name="user.age"> <br> 性别： <input
				type="text" name="user.sex"> <br> 地址： <input
				type="text" name="user.address"> <br> 出生日期： <input
				type="text" name="user.birth"> <br>
			<input type="submit" value="提交">
		</form>
	</div>
</body>
</html>
