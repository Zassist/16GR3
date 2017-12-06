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
	<div class="menu"></div>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">账单管理&gt;&gt;</div>
		</div>
		<form method="post" action="account?cmd=updateAccount">
			<div class="content">
				<input type="hidden" name="accountid"
					value="${accounttal.accountId}">
				<table class="box">
					<tr>
						<th class="field">账单编号：</th>
						<td>${accounttal.accountId}</td>
					</tr>
					<tr>
						<th class="field">商品名称：</th>
						<td><input type="text" name="goodsName" class="text"
							value="${accounttal.goodsName}" /></td>
					</tr>
					<tr>
						<th class="field">交易数量：</th>
						<td><input type="text" name="businessNum" class="text"
							value="${accounttal.businessNum}" /></td>
					</tr>
					<tr>
						<th class="field">供应商：</th>
						<td><select name="providerId">
								<c:forEach items="${providers}" var="provider">
									<option selected="selected" value="${provider.providerId }">${provider.providerName }</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<th class="field">是否付款：</th>
						<td><select name="isPayed">
								<c:if test="accountta${accounttal.isPayed == '1' }">
									<option selected="selected" value="1">是</option>
									<option value="0">否</option>
								</c:if>
								<c:if test="accountta${accounttal.isPayed != '1' }">
									<option value="1">是</option>
									<option selected="selected" value="0">否</option>
								</c:if>
						</select></td>
					</tr>
				</table>
			</div>
			<div class="buttons">
				<input type="button" name="button" value="返回" class="input-button"
					onclick="history.back();" /> <input type="submit" value="修改"
					class="input-button" /> <a style="text-decoration: none;"
					class="input-button"
					href="account?cmd=deleteAccount&&accountId=${param.accountId }">删除</a>
			</div>
		</form>
	</div>
</body>
</html>