<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'userAdmin.jsp' starting page</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="menu">
		<table>
			<tbody>
				<tr>
					<td>
						<form method="post" action="user.do">
							<input name="flag" value="search" class="input-text"
								type="hidden"> 用户名称：<input name="userName"
								class="input-text" type="text">&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="getUser?user.userName=${user.userName }">查 询</a>
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">

		<div class="optitle clearfix">
			<em><input value="添加数据" class="input-button"
				onclick="window.location='http://localhost:8080/Struts2T8/jsp/userAdd.jsp'"
				type="button"></em>
			<div class="title">用户管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tbody>
					<tr>
						<td width="60" height="29"><div class="STYLE1" align="center">编号</div></td>
						<td width="70"><div class="STYLE1" align="center">用户名称</div></td>
						<td width="70"><div class="STYLE1" align="center">头像</div></td>
						<td width="90"><div class="STYLE1" align="center">性别</div></td>
						<td width="90"><div class="STYLE1" align="center">年龄</div></td>
						<td width="120"><div class="STYLE1" align="center">电话</div></td>
						<td width="120"><div class="STYLE1" align="center">地址</div></td>
						<td width="120"><div class="STYLE1" align="center">权限</div></td>
						<td width="120"><div class="STYLE1" align="center">操作</div></td>
						
					</tr>
					<s:iterator value="users" var="user">
						<tr>
							<td height="23"><span class="STYLE1">${user.userId }</span></td>
							<td><span class="STYLE1"><a href="#"
									onclick="doit('mod',1)">${user.userName }</a></span></td>
							<td><span class="STYLE1"> <img alt="photo"
									style="width: 60px; height: 60px;" src="${user.pic}">
							</span></td>
							<td><span class="STYLE1">${user.userSex }</span></td>
							<td><span class="STYLE1"> <s:if
										test='#user.userSex == "M"'>
									男
								</s:if> <s:else>
									女
								</s:else>
							</span></td>
							<td><span class="STYLE1">${user.telephone }</span></td>
							<td><span class="STYLE1">${user.address }</span></td>
							<td><span class="STYLE1"> <s:if
										test="#user.type == 1">
									管理员
								</s:if> <s:else>
									普通用户
								</s:else>
							</span></td>
							<td><span class="STYLE1">
								<a href="toUpdateUser?user.userId=${user.userId }">修改</a> 
								<a href="deleteUser?user.userId=${user.userId }">删除</a>
								</span>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>