<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
</head>
<body>
<div class="menu">

</div>
<div class="main">
<div class="optitle clearfix">
<em><input value="添加数据" class="input-button" onclick="window.location='jsp/providerAdd.jsp'" type="button"></em>
		<div class="title">供应商管理&gt;&gt;</div>
	</div>

	<div class="content">
<table class="list">
  <tbody><tr>
    <td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
    <td width="80"><div class="STYLE1" align="center">供应商名称</div></td>
    <td width="100"><div class="STYLE1" align="center">供应商描述</div></td>
    <td width="100"><div class="STYLE1" align="center">联系人</div></td>
    <td width="100"><div class="STYLE1" align="center">电话</div></td>
    <td width="100"><div class="STYLE1" align="center">传真</div></td>
    <td width="100"><div class="STYLE1" align="center">地址</div></td>
    <td width="100"><div class="STYLE1" align="center">操作</div></td>
    </tr>
    <c:forEach items="${pageBean.data}" var="providers">
			<tr>
				<td>${providers.providerId}</td>
				<td>${providers.providerName}</td>
				<td>${providers.providerDetail}</td>
				<td>${providers.contact}</td>
				<td>${providers.telephone}</td>
				<td>${providers.facsimile}</td>
				<td>${providers.address}</td>
				<td><a href="provider?cmd=delProvider&&providerId=${providers.providerId}">删除</a></td>
			</tr>
	</c:forEach>
</tbody></table>
	</div>
	<form id="frm" action="provider?cmd=allProvider">
		<label class="input-button">跳转到</label>
			<select  name="p" onchange="getPageByp();">
				<c:forEach var="j" begin="1" end="${pageBean.getPagetotal()}">
					<c:if test="${pageBean.getP() ==j }">
						<option selected="selected" value="${j }">第${j }页</option>
					</c:if>
					<c:if test="${pageBean.getP() !=j }" >
						<option value="${j }">第${j }页</option>
					</c:if>
				</c:forEach>
			</select>
			<a class="input-button" href="provider?cmd=allProvider&p=${pageBean.p -1 }">上一页</a>
	<a class="input-button" href="provider?cmd=allProvider&p=${pageBean.p -1 }">下一页</a>
	</form>
	<script type="text/javascript">
		function getPageByp(){
		var frm=document.getElementById("frm");
			frm.submit();
		}
	</script>
</div>
</body></html>
