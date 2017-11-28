<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<h6 align="center">这里是success.jsp</h6>
  <s:property value="user.uname"/><br>
  <s:property value="user.upwd"/><br>
  <s:property value="user.age"/><br>
  <s:property value="user.sex"/><br>
  <s:property value="user.telephone"/><br>
  <s:iterator value="user.loves" var="love">
  ${love }<br>
  </s:iterator>
</body>
</html>