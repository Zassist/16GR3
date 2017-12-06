<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<form method="post" action="account?cmd=updateAccount">
		<div class="content">
			<table class="box">
				<tbody>
					<tr>
						<th class="field">供应商名称：</th>
						<td><input name="providerName" class="text" type="text">
							<font color="red">*</font></td>
					</tr>
					<tr>
						<th class="field">供应商描述：</th>
						<td><textarea name="providerDetail" cols="45" rows="5"></textarea></td>
					</tr>
					<tr>
						<th class="field">供应商姓名：</th>
						<td><input name="contact" class="text" type="text"></td>
					</tr>
					<tr>
						<th class="field">供应商电话：</th>
						<td><input name="telephone" class="text" type="text"></td>
					</tr>
					<tr>
						<th class="field">供应商传真：</th>
						<td><input name="facsimile" class="text" type="text"></td>
					</tr>
					<tr>
						<th class="field">供应商地址：</th>
						<td><input name="address" class="text" type="text"></td>
					</tr>
				</tbody>
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
</body>
</html>