<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有用户</title>
</head>
<body>
	<center>
		<h2>用户信息</h2>
		<table>
			<tr>
				<th>用户ID</th>
				<th>用户名</th>
				<th>密码</th>
				<th>出生日期</th>
				<th>性别</th>
				<th>是否启用</th>
				<th>操作</th>
			</tr>
			<s:iterator value="users" var="user">
				<tr>
					<td><s:property value="#user.id" /></td>
					<td><s:property value="#user.name" /></td>
					<td><s:property value="#user.password" /></td>
					<td><s:property value="#user.birthday" /></td>
					<td><s:if test='#user.sex == "M"'>男</s:if> <s:else>女</s:else></td>
					<td><s:if test="#user.active == 1">是</s:if> <s:else>否</s:else></td>
					<td><s:a href="toupdate_user?user.id=%{#user.id}">修改</s:a>&nbsp;<a
						href="del_user?user.id=${user.id}">删除</a></td>
				</tr>
			</s:iterator>
		</table>
	</center>
	<a href="jsp/adduser.jsp">添加用户</a>
</body>
</html>