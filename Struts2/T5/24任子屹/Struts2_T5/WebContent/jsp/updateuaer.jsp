<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改界面</title>
</head>
<body>
	<center>
		<form action="update_user" method="post">
			<s:hidden name="user.id"></s:hidden>
			用户名：
			<s:textfield name="user.name" required="true"></s:textfield>
			<br> 密码：
			<s:password name="user.password" required="true"></s:password>
			<br> 出生日期：
			<s:textfield name="user.birthday" required="true"></s:textfield>
			<br> 性别：
			<s:radio name="user.sex" list="#{'M':'男','F':'女'}" value="user.sex"></s:radio>
			<br> 是否启用：
			<s:select name="user.active" list="#{1:'是',0:'否'}" value="user.active"></s:select>
			<br> <input type="submit" value="提交">
		</form>
	</center>
</body>
</html>