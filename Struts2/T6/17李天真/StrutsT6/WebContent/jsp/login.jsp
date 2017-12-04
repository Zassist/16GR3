<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="global.login"></s:text></title>
</head>
<body>
<h1><s:text name="global.login"></s:text></h1>

<s:form action="loginUser" namespace="/user">
	<s:textfield key="glogal.username" name="user.uname"></s:textfield>
	<s:password key="glogal.password" name="user.upwd"></s:password>
	<s:submit key="glogal.login" name="glogal.login"></s:submit>
	
</s:form>
<s:url id="localeEN" namespace="/" action="local">
	<s:param name="request_locale">zh_)CN</s:param>
</s:url>
<s:a href="%{localeEN}">English</s:a>
<s:a href="%{localezhCN}">Chinese</s:a>
</body>
</html>