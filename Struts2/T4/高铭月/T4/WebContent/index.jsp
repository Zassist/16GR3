<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:form action="user" method="post">
		<s:textfield lable="用户名" name="user.uname"></s:textfield>
		<s:password lable="密码" name="user.upwd"></s:password>
		<s:checkboxlist label="愛好" list="{'打球','吃','喝','玩','乐'}" name="user.xiaoming"></s:checkboxlist>
		<s:submit value="登录"></s:submit>
		</table>
	</s:form>
</body>
</html>