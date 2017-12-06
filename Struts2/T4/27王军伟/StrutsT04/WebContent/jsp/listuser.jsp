<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户界面</title>
</head>
<body>
	<center>
	<s:a href="useradd.jsp">添加</s:a>
		<table>
			<tr>
				<th>用户ID</th>
				<th>用户名</th>
				<th>密码</th>
				<th>性别</th>
				<th>学历</th>
			</tr>
			<s:iterator value="userlist" var="user">
				<tr>
					<td><s:property value="#user.id" /></td>
					<td><s:property value="#user.name" /></td>
					<td><s:property value="#user.password" /></td>
					<td><s:if test="#user.sex == 1">男</s:if> <s:else>女</s:else></td>
					<td><s:property value="#user.edu" /></td>
				</tr>
			</s:iterator>
		</table>
	</center>
</body>
</html>