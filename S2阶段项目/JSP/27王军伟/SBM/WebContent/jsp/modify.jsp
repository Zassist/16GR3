<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
</head>
<body>
	<div class="main">
		<form method="post" action="../account?cmd=addaccount">
			<div class="content">
				<table class="box">
					<tr>
						<th class="field">商品名称：</th>
						<td><input type="text" name="goodsName" class="text" /></td>
					</tr>
					<tr>
						<th class="field">交易数量：</th>
						<td><input type="text" name="businessNum" class="text" /></td>
					</tr>
					<tr>
						<th class="field">供应商：</th>
						<td><select name="providerId">
								<c:forEach items="${providers}" var="provider">
									<option value="${provider.providerid}">${provider.providername}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<th class="field">是否付款：</th>
						<td><select name="isPayed">
								<option value="1">已付</option>
								<option value="0">未付</option>
						</select></td>
					</tr>
				</table>
			</div>
			<div class="buttons">
				<input type="submit" name="submit" value="确认" class="input-button" />
				<input type="button" name="button" value="返回" class="input-button"
					onclick="history.back();" />
			</div>
		</form>
	</div>
</body>
</html>
