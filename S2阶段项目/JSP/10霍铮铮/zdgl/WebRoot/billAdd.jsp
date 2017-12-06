<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="/zdgl/css/style.css" />
</head>
<body>
<div class="menu">
	<form method="get" action="">
		商品名称：<input type="text" name="productName" class="input-text" />&nbsp;&nbsp;&nbsp;&nbsp;
		是否付款：<select name="payStatus">
			<option value="">请选择</option>
			<option value="1">已付款</option>
			<option value="0">未付款</option>
		</select>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="submit" value="组合查询" class="button" />
	</form>
</div>
<div class="main">
	<div class="optitle clearfix">
		<em><input type="button" name="button" value="添加数据" class="input-button" onclick="location.href='modify.html'" /></em>
		<div class="title">账单管理&gt;&gt;</div>
	</div>
	<form method="post" action="/zdgl/account/accountServlet?action=${account==null ? 'add' : 'upd' }">
		<input type="hidden" value="${account.accountId}" name="accountId"/>
		<div class="content">
			<table class="box">
				<tr>
					<td class="field">商品名称：</td>
					<td>
						<select name = "goodsId">
							<c:forEach items="${goods}" var="good">
								<option value="${good.goodsId}" ${account.goodsId==good.goodsId ? 'selected' : '' }>${good.goodsName}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="field">商品数量：</td>
					<td><input type="text" name="businessNum" class="text" value="${account.businessNum }" /></td>
				</tr>
				<tr>
					<td class="field">交易金额：</td>
					<td><input type="text" name="totalPrice" class="text" value="${account.totalPrice }" /></td>
				</tr>
				<tr>
					<td class="field">是否付款：</td>
					<td><select name="isPayed">
						<option value="1" ${account.isPayed==1 ? 'selected' : '' }>是</option>
                        <option value="0" ${account.isPayed==0 ? 'selected' : '' }>否</option>
					</select></td>
				</tr>
				<tr>
					<td class="field">供应商名称：</td>
					<td>
						<select name="providerId">
							<c:forEach items="${providers}" var="provider">
								<option value="${provider.providerId}" ${account.providerId==provider.providerId ? 'selected' : '' }>${provider.providerName}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="field">账单日期：</td>
					<td><input type="text" name="accountDate" class="text" value="${account.accountDate }" /></td>
				</tr>
			</table>
		</div>
		<div class="buttons">
			<input type="submit" name="submit" value="确认" class="input-button" />
			<input type="button" name="button" value="返回" class="input-button" onclick="history.back();" />
		</div>
	</form>
</div>
</body>
</html>
