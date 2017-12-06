<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../css/style.css">
<script type="text/javascript">
	function doit(flag, id) {
		if (flag == "del") {
			if (confirm("确认删除吗？") != true)
				return;
		}
	}
</script>
</head>
<body>
	<div class="menu">
		<table>
			<tbody>
				<tr>
					<td><form method="post" action="../user?cmd=query">
							<input name="flag" value="search" class="input-text"
								type="hidden"> 用户名称：<input name="userName"
								class="input-text" type="text">&nbsp;&nbsp;&nbsp;&nbsp;
							<input class="button" value="查 询" type="submit">
						</form></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">

		<div class="optitle clearfix">
			<em><input value="添加数据" class="input-button"
				onclick="window.location='userAdd.jsp'" type="button"></em>
			<div class="title">用户管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tbody>
					<tr>
						<th width="70" height="29"><div class="STYLE1" align="center">编号</div></th>
						<th width="80"><div class="STYLE1" align="center">用户名称</div></th>
						<th width="100"><div class="STYLE1" align="center">性别</div></th>
						<th width="100"><div class="STYLE1" align="center">年龄</div></th>
						<th width="150"><div class="STYLE1" align="center">电话</div></th>
						<th width="150"><div class="STYLE1" align="center">地址</div></th>
						<th width="150"><div class="STYLE1" align="center">权限</div></th>
					</tr>
					<c:forEach items="${users.data}" var="user">
						<tr>
							<td height="23"><span class="STYLE1">${user.userId}</span></td>
							<td><span class="STYLE1">${user.userName}</span></td>
							<td><span class="STYLE1"><c:if
										test="${user.userSex == 'm'}">男</c:if> <c:if
										test="${user.userSex != 'm'}">女</c:if></span></td>
							<td><span class="STYLE1">${user.userAge}</span></td>
							<td><span class="STYLE1">${user.telephone}</span></td>
							<td><span class="STYLE1">${user.address}</span></td>
							<td><span class="STYLE1"><c:if
										test="${user.type != 0}">经理</c:if> <c:if
										test="${user.type == 0}">员工</c:if></span></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<form id="form" method="post" action="provide?cmd=getPageBean">
			<label class="input-button">跳转到</label> <select name="p"
				onchange="getPageBeanByP();">
				<c:forEach var="j" begin="1" end="${users.pagetotal}">
					<c:if test="${users.p == j}">
						<option selected="selected" value="${j}">第${j}页</option>
					</c:if>
					<c:if test="${users.getP() != j}">
						<option value="${j}">第${j}页</option>
					</c:if>
				</c:forEach>
			</select> <a class="input-button"
				href="../user?cmd=getPageBean&&p=${users.p - 1 }">上一页</a> <a
				class="input-button"
				href="../user?cmd=getPageBean&&p=${users.p + 1 }">下一页</a>
		</form>
	</div>
</body>
</html>