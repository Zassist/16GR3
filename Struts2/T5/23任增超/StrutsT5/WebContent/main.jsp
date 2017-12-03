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
	<h2>用户信息</h2>
	<a href="jsp/addUser.jsp">添加用户</a>
	<table border="1px">
		<tr>
			<th>用户ID</th>
			<th>用户名</th>
			<th>密码</th>
			<th>生日</th>
			<th>性别</th>
			<th>是否启用</th>
			<th>操作</th>
		</tr>
		<s:iterator value="list" var="user">
			<tr>
				<td>${user.id }</td>
				<td>${user.uname }</td>
				<td>${user.upwd }</td>
				<td>${user.birthday }</td>
				<td><s:if test='#user.sex == "M"'>男</s:if> <s:else>女</s:else></td>
				<td><s:if test="#user.enable == 0">否</s:if><s:else>是</s:else></td>
				<td>
				<a href="toUpdateUser?user.id=${user.id }">修改</a> 
				<a href="deleteUser?user.id=${user.id }">删除</a></td>
			</tr>
		</s:iterator>
	</table>

</body>
</html>