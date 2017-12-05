<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="login.title"></s:text></title>
</head>
<body>
<s:form action="loginUser" namespace="/user">
	<s:textfield key="global.username" name="user.uname"  />
	<s:password key="global.password" name="user.upwd"/>	
	<s:submit key="global.login" name="global.login" />
</s:form>
<s:url id="localeEN" namespace="/" action="local" >
   <s:param name="request_locale" >en_US</s:param>
</s:url>
<s:url id="localezhCN" namespace="/" action="local" >
   <s:param name="request_locale" >zh_CN</s:param>
</s:url>
<s:a href="%{localeEN}" >English</s:a>
<s:a href="%{localezhCN}" >Chinese</s:a>
</body>
</html>