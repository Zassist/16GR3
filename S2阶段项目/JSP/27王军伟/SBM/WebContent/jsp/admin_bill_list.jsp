<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
</head>
<body>
	<div class="menu">
		<form method="post" action="../account?cmd=query">
			商品名称：<input type="text" name="goodsName" class="input-text" />
			&nbsp;&nbsp;&nbsp;&nbsp; 是否付款：<select name="isPayed">
				<option value="">请选择</option>
				<option value="1">已付款</option>
				<option value="0">未付款</option>
			</select> &nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" value="组合查询"
				class="button" />
		</form>
	</div>
	<div class="main">
		<div class="optitle clearfix">
			<em><input type="button" name="button" value="添加数据"
				class="input-button" onclick="location.href='modify.jsp'" /></em>
			<div class="title">账单管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tr>
					<th>账单编号</th>
					<th>商品名称</th>
					<th>交易数量</th>
					<th>交易金额</th>
					<th>是否付款</th>
					<th>供应商名称</th>
					<th>商品描述</th>
					<th>账单时间</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${accountstal.data}" var="accounttal">
					<tr>
						<td>${accounttal.accountId}</td>
						<td>${accounttal.goodsName}</td>
						<td>${accounttal.businessNum}</td>
						<td>${accounttal.totalPrice}</td>
						<td><c:if test="${accounttal.isPayed == '1'}">
						已付款
					</c:if> <c:if test="${accounttal.isPayed == '0'}">
						未付款
					</c:if></td>
						<td>${accounttal.providerName}</td>
						<td>${accounttal.goodsIntro}</td>
						<td>${accounttal.accountDate}</td>
						<td><a href="updateAccount.jsp?accounttal=${accounttal}">修改/删除</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<form id="form" method="post" action="account?cmd=getPageBean">
			<label class="input-button">跳转到</label> <select name="p"
				onchange="getPageBeanByP();">
				<c:forEach var="j" begin="1" end="${accountstal.pagetotal}">
					<c:if test="${accountstal.p == j}">
						<option selected="selected" value="${j}">第${j}页</option>
					</c:if>
					<c:if test="${accountstal.getP() != j}">
						<option value="${j}">第${j}页</option>
					</c:if>
				</c:forEach>
			</select> <a class="input-button"
				href="../account?cmd=getPageBean&&p=${accountstal.p - 1 }">上一页</a> <a
				class="input-button"
				href="../account?cmd=getPageBean&&p=${accountstal.p + 1 }">下一页</a>
		</form>
	</div>
	<script type="text/javascript">
		function getPageBeanByP() {
			var form = document.getElementById("form");
			form.submit();
		}
	</script>
</body>
</html>