<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
  <a href="jsp/addUser.jsp">添加用户</a>
     <div class="wrap">
          <h2>用户列表</h2>
          <table border="1">
                 <tr>
                     <td>用户Id</td>
                     <td>用户姓名</td>
                     <td>用户密码</td>
                     <td>用户生日</td>
                     <td>用户性别</td>
                     <td>是否启用</td>
                     <td>操作</td>                     
                 </tr>
                 <s:iterator value="users" var="user">
                 <tr>
                     <td>${user.id }</td>
                     <td>${user.uname }</td>
                     <td>${user.upwd }</td>
                     <td>${user.birthday }</td>
                     <td>
                         <s:if test='user.sex == "M"'>
                                                                                               男
                         </s:if>
                         <s:else>女</s:else>
                     </td>
                     <td>
                         <s:if test="user.enable == 1">
                                                                                                是
                         </s:if>
                         <s:else>否</s:else>
                     </td>
                     <td>
                      <a href="toUpdate?user.id=${user.id }">修改</a>
                      <a href="delete?user.id=${user.id }">删除</a>
                     </td>                     
                 </tr>
                 </s:iterator>
          </table>
     </div>
  </body>
</html>
