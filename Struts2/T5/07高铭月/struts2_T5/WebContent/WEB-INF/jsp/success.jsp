<%@ page language="java" contentType="text/html; charset=UTF-8"

	pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>

<!-- 获得本页请求地址URL   http://localhost:8080/Struts2T05/jsp/success.jsp -->

<!-- <base href="http://localhost:8080/Struts2T05/jsp"/> -->

</head>

<body>

	<h2 align="center">success页面</h2>

	<div align="center">

		<table border="1" style="text-align: center;" width="70%">

			<tr>

				<td>编号</td>

				<td>名字</td>

				<td>密码</td>

				<td>生日</td>

				<td>性别</td>

				<td>是否启用</td>

				<td>操作</td>

			</tr>

			<s:iterator value="userlist" var="ulist">

				<tr>

					<td><s:property value="#ulist.id"></s:property></td>

					<td>${ulist.uname }</td>

					<td>${ulist.upwd }</td>

					<td>${ulist.birthday }</td>



					<td><s:if test='#ulist.sex == "M"'>

		男

		</s:if> <s:else>

		女

		</s:else></td>



					<td><s:if test='#ulist.uenable == 0'>

		否

		</s:if> <s:else>

		是

		</s:else></td>



					<td><s:a href="skip/user_toUpdateUser?user.id=%{#ulist.id}">修改</s:a>&emsp;<s:a

							href="skip/user_deleteUser?user.id=%{#ulist.id}">删除</s:a></td>

				</tr>

			</s:iterator>

			<tr>

				<td colspan="7" style="text-align: right;"><a href="http://localhost:8080/Struts2T05/jsp/adduser.jsp">添加用户<a>&emsp;&emsp;&emsp;</td>

			</tr>

		</table>

	</div>

</body>

</html>