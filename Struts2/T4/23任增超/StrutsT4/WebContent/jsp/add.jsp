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
	账户:<s:property value="user.uname"/><br>
	密码:<s:property value="user.upwd"/><br>
	性别:<s:property value="user.sex"/><br>
	学历:<s:property value="user.edu"/><br>
</body>
</html>