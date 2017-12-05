<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head><body>




<div class="menu">

</div>
<div class="main">

<div class="optitle clearfix">
<em><input value="添加数据" class="input-button" onclick="window.location='jsp/userAdd.jsp'" type="button"></em>
		<div class="title">用户管理&gt;&gt;</div>
	</div>
	<div class="content">
<table class="list">
  <tbody><tr>
    <td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
    <td width="100"><div class="STYLE1" align="center">头像</div></td>
    <td width="80"><div class="STYLE1" align="center">用户名称</div></td>
    <td width="100"><div class="STYLE1" align="center">性别</div></td>
    <td width="100"><div class="STYLE1" align="center">年龄</div></td>
    <td width="150"><div class="STYLE1" align="center">电话 </div></td>
    <td width="150"><div class="STYLE1" align="center">地址 </div></td>
    <td width="150"><div class="STYLE1" align="center">权限 </div></td>
    <td width="150"><div class="STYLE1" align="center">删除</div></td>
  </tr>
  
  <tr>
    <c:forEach items="${pageBean.data}" var="userDetail">
			<tr>
				<td>${userDetail.userId}</td>
				<td><img src="${basePath }${userDetail.pic}"></td>
				<td>${userDetail.userName}</td>
				<td>${userDetail.userSex}</td>
				<td>${userDetail.userAge}</td>
				<td>${userDetail.telephone}</td>
				<td>${userDetail.address}</td>
				<td>
					<c:if test="${accountDetail.type == 1}">
						雇员
					</c:if>
					<c:if test="${accountDetail.type == 0}">
						经理
					</c:if>
				</td>
				<td><a href="user?cmd=delUser&&auserId=${userDetail.userId }">删除</a></td>
			</tr>
			</c:forEach>
  </tr>
</tbody></table>
</div>
</div>
</body></html>
