<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addUser.jsp' starting page</title>
    
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
   	<h3>修改用户</h3>
   		
   		<s:form action="UserAction_updateUser" method="post" theme="simple">
	   <table border="1">
	   			<tr>
	   				<td>ID</td>
	   				<td><s:textfield name="employee.id" readonly="true" ></s:textfield></td>
    			</tr>
    			<tr>
    				<th>姓名</th>
    				<td> <s:textfield name="employee.name"></s:textfield> </td>
    			</tr>
    			<tr>
    				<th>密码</th>
    				<td> <s:textfield name="employee.pwd"></s:textfield> </td>
    			</tr>
    			<tr>
    				<th>性别</th>
    				<td>
    					<s:radio name="employee.sex" list="#{'M':'男','F':'女' }" value="employee.sex" ></s:radio>
    				</td>
    			</tr>
    			<tr>
    				<th>生日</th>
    				<td> <s:textfield name="employee.birth"></s:textfield> </td>
    			</tr>
    			<tr>
    				<th>是否启用</th>
    				<td> <s:checkbox name="employee.isActive" value="employee.isActive" ></s:checkbox> </td>
    			</tr>
    		</table>
    		<input type="submit" value="修改" />
    	</s:form>
    	
    	
   	</center>
  </body>
</html>
