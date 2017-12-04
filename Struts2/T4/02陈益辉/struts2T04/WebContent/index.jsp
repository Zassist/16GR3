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
  <s:form action="add" namespace="/user" method="post">
	  <s:textfield label="姓名" name="user.uname" required="true"></s:textfield>
	  <s:password label="密码" name="user.upwd" required="true"></s:password>
	  <s:textfield label="年龄" name="user.age" required="true"></s:textfield>
	  <s:radio label="性别" name="user.sex" list="#{'M':'男','F':'女'}" value="'M'"></s:radio>
	  <s:textfield label="电话号码" name="user.telephone" required="true"></s:textfield>
	  <s:checkboxlist label="个人爱好" name="user.loves" list="{'篮球','乒乓球','铅球','各种球'}"></s:checkboxlist>
	  <s:submit value="添加"></s:submit>
  </s:form>
</body>
</html>