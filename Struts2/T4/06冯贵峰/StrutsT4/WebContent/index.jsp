<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
  <s:form action="/user" method="post">
     <s:textfield label="用户名" name="user.name" required="true"></s:textfield>
     <s:password label="密码" name="user.password" required="true"></s:password>
     <s:radio label="性别" list="#{'M':'男','F':'女' }" name="user.sex" value="'M'"></s:radio>
     <s:select label="学历" list="{'初中','高中','大学','博士'}" name="user.education" value="'大学'"></s:select>
     <s:checkboxlist label="爱好" list="{'打太极','跳舞','跑步','唱歌','串门'}" name="user.like" value="'串门'"></s:checkboxlist>
     <s:submit value="注册"></s:submit>
  </s:form>
</body>
</html>