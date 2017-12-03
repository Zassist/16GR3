<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <center>
    <h1>小柚子网站注册界面</h1>
    <s:form action="user" method="post" >
    <s:textfield label="用户名" name="user.uname" required="true" ></s:textfield>
    <s:password label="密码" name="user.upwd" required="true"></s:password>
    <s:select label="年龄" list="{16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,
                                31,32,33,34,35,36,37,37,38,40,41,42,43,44,45,46,47,48,49,50,
                                51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,
                                 71,72,73,74,75,76,77,78,79,80,81,82,83,84,75,86,87,88,89,90,
                                 91,92,93,94,95,96,97,98,99}" name="user.age"></s:select>
                                  <s:radio label="性别" list="#{'男':'男','女':'女' }" name="user.sex" value="'男'"></s:radio>
    <s:select label="学历" list="{'初中','高中','大专','本科'}" name="user.edu"></s:select>
    <s:checkboxlist label="爱好" list="{'唱歌','跳舞','跑步','睡觉'}" name="user.like"></s:checkboxlist>
    <s:submit value="注册" ></s:submit>
    </s:form>
    </center>
  </body>
</html>
