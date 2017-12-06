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
<h6 align="center">success.jsp</h6>
<s:set var="TZ" value="{'徐红旗','于志胜'}" ></s:set>
<s:set var="user" value="#{'name':'徐红旗','age':22}" ></s:set>
<s:property value="#TZ[0]"/><br>
<s:property value="#TZ[1]"/><br>
<s:property value="#user['name']"/><br>
<s:property value="#user['age']"/><br>
${TZ[1] }
<br>
<form action="userInfo" method="post">
姓名：<input type="text" name="user.uname"><br>
密码：<input type="password" name="user.upwd"><br>
年龄：<input type="text" name="user.age"><br>
电话：<input type="text" name="user.telephone"><br>
生日：<input type="text" name="user.birthday"><br>
<input type="submit" value="提交">
</form>
</body>
</html>