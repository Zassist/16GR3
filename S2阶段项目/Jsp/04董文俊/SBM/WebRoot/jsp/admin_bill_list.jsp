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
    
    <title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<div class="menu">
	<form method="post" action="account?cmd=getAccountBywhere">
		商品名称：<input type="text" name="goodsName" class="input-text" />&nbsp;&nbsp;&nbsp;&nbsp;
		是否付款：<select name="isPayed">
			<option value="">请选择</option>
			<option value="1">已付款</option>
			<option value="0">未付款</option>
		</select>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="submit" value="组合查询" class="button" />
	</form>
</div>
<div class="main">
	<div class="optitle clearfix">
		<em><input type="button" name="button" value="添加数据" class="input-button" onclick="location.href='provider?cmd=getProviders&action=addAccount'" /></em>
		<div class="title">账单管理&gt;&gt;</div>
	</div>
	<div class="content">
		<table class="list">
			<tr>
				<td>账单编号</td>
				<td>商品名称</td>
				<td>交易数量</td>
				<td>交易金额</td>
				<td>是否付款</td>
				<td>供应商名称</td>
				<td>商品描述</td>
				<td>账单时间</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${pageBean.data}" var="accountDetail">
			<tr>
				<td>${accountDetail.accountId}</td>
				<td>${accountDetail.goodsName}</td>
				<td>${accountDetail.businessNum}</td>
				<td>${accountDetail.totalPrice}</td>
				<td>
					<c:if test="${accountDetail.isPayed == 1}">
						已付款
					</c:if>
					<c:if test="${accountDetail.isPayed == 0}">
						未付款
					</c:if>
				</td>
					<td>${accountDetail.providerName}</td>
					<td>${accountDetail.goodsIntro}</td>
					<td>${accountDetail.accountDate}</td>
					<td><a href="provider?cmd=getProviders&&action=update&&accountId=${accountDetail.accountId }">修改</a></td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<form id="frm" action="account?cmd=allAccount" method="post">
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
	<a class="input-button" href="account?cmd=allAccount&p=${pageBean.p -1 }">上一页</a>
	<a class="input-button" href="account?cmd=allAccount&p=${pageBean.p +1 }">下一页</a>
	</form>
	
</div>
	<script type="text/javascript">
		function getPageByp(){
		var frm=document.getElementById("frm");
			frm.submit();
		}
	</script>
</body>
</html>
