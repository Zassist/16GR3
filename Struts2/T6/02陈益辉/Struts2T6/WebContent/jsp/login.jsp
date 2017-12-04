<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="label.title"/></title>
</head>
<body>
<h2 align="center">login.jsp</h2>
<div align="center">
<s:form action="Login_user" method="post">
<s:textfield key="label.uname" name="loginInfo.uname"></s:textfield>
<s:password key="label.upwd" name="loginInfo.upwd"></s:password>
<s:submit key="label.login"></s:submit>
</s:form>
<s:fielderror fieldName="loginInfo.info"/>
<s:actionerror/>

<%-- <s:url id="localeenEN" action="local" > --%>
<%--    <s:param name="request_locale" >en_US</s:param> --%>
<%-- </s:url> --%>
<%-- <s:url id="localezhCN" action="local" > --%>
<%--    <s:param name="request_locale" >zh_CN</s:param> --%>
<%-- </s:url> --%>
<%-- <a href="<s:property value="#localeenEN"/>">English</a> --%>
<%-- <a href="<s:property value="#localezhCN"/>">中文</a> --%>
</div>
</body>
</html>