<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../css/style.css">
<script type="text/javascript">
	function checkit() {
		//判断是否是数字的正则表达式
		return true;
	}
</script>
</head>
<body>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">用户管理&gt;&gt;</div>
		</div>
		<form id="form1" name="form1" method="post"
			action="../user?cmd=register" onsubmit="return checkit();">
			<input type="hidden" name="flag" value="doAdd">
			<div class="content">
				<table class="box">
					<font style="color: red;">请填写添加用户的详细信息</font>
					<tr>
						<th class="field">用户名称：</th>
						<td><input type="text" name="userName" class="text"
							id="userName" /> <font color="red">*</font></td>
					</tr>
					<tr>
						<th class="field">用户密码：</th>

						<td><input type="password" name="userPassword" class="text"
							id="userPassword" /> <font color="red">*</font></td>
					</tr>
					<tr>
						<th class="field">确认密码：</th>
						<td><input type="password" name="userPassword2" class="text" />
							<font id="userPassword2" color="red">*</font></td>
					</tr>
					<tr>
						<th class="field">用户性别：</th>
						<td><select name="userSex" id="userSex">
								<option value="0">女</option>
								<option value="1" disabled="disabled">男</option>
						</select></td>
					</tr>

					<tr>
						<th class="field">用户年龄：</th>
						<td><input type="text" name="userAge" class="text"
							id="userAge" /> <font color="red">*</font></td>
					</tr>
					<tr>
						<th class="field">用户电话：</th>
						<td><input type="text" name="telephone" class="text"
							id="telephone" /> <font color="red">*</font></td>

					</tr>
					<tr>
						<th class="field">用户地址：</th>
						<td><textarea name="address" id="address" class="text"
								cols="45" rows="5"></textarea></td>
					</tr>
					<tr>
						<th class="field">用户权限：</th>
						<td><input type="radio" name="type" id="type" value="0"
							checked="checked" />普通用户 <input type="radio" name="type"
							id="auth" value="1" />经理</td>
					</tr>
					<tr>
						<th class="field">用户头像：</th>
						<td><input type="file"> <font id="userPassword2"
							color="red">请酌情上传</font></td>
					</tr>
				</table>
			</div>
			<div class="buttons">
				<input type="submit" value="数据提交" class="input-button" /> <input
					type="button" onclick="window.location='userAdmin.jsp';" value="返回"
					class="input-button" />
			</div>
		</form>
	</div>
</body>
</html>
