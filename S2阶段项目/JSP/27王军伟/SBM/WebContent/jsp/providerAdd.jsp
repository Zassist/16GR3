<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
</head>
<body>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">供应商管理&gt;&gt;</div>
		</div>
		<form id="form1" name="form1" method="post" action="provider.do"
			onsubmit="return checkit();">
			<div class="content">
				<font color="red"></font> <input name="flag" value="doAdd"
					type="hidden">
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
				<input name="button" id="button" value="提交" class="input-button"
					type="submit"> <input name="button" id="button"
					onclick="window.location='providerAdmin.jsp';" value="返回"
					class="input-button" type="button">
			</div>
		</form>
	</div>
</body>
</html>