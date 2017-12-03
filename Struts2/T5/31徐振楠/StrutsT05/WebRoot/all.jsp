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
    
    <title>My JSP 'all.jsp' starting page</title>
    
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
  <a href="add.jsp">添加用户</a>
  <br>
    	<table border="1px">
			<tr>
				<td>用户Id</td>
                <td>用户名</td>
			    <td>密码</td>
			    <td>年龄</td>
			    <td>性别</td>
			    <td>学历</td>
			    <td>地址</td>
			    <td>电话</td>
			    <td>操作</td>
          </tr>
			<s:iterator value="users" var="user">
				<tr>
          <td> <s:property value="#user.uid"/></td>
          <td> <s:property value="#user.uname"/></td>
          <td> <s:property value="#user.upwd"/></td>
          <td> <s:property value="#user.age"/></td>
          <td> <s:property value="#user.sex"/></td>
          <td> <s:property value="#user.edu"/></td>
          <td> <s:property value="#user.address"/></td>
          <td> <s:property value="#user.tel"/></td>
     <td>
     <a href="toupdUser?user.uid=${user.uid }">修改</a>
     <a href="del?user.uid=${user.uid}">删除</a>
     </td>   
  </tr>
			</s:iterator>
		</table>
    </center>
  </body>
</html>
     