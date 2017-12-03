<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div class="wrap">
			<h2>修改页面</h2>
		<table border="1px">
			<s:form action="updateUser" method="post">
				<s:hidden label="用户ID" name="user.id"></s:hidden>
				<s:textfield label="用户名" name="user.uname" required="true" ></s:textfield>
				<s:textfield label="密码" name="user.upwd" required="true" ></s:textfield>
				<s:textfield label="生日" name="user.birthday" required="true"></s:textfield>
				<s:radio label="性别" name="user.sex" list="#{'M':'男','F':'女' }" value='"M"'></s:radio>
				<s:select label="是否启用" name="user.enable" list="#{1:'是',0:'否' }" value="0" ></s:select>
				<s:submit value="提交"></s:submit>
			</s:form>
		</table>
	</div>
</body>
</html>