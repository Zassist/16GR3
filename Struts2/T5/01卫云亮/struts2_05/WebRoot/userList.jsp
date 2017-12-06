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
    
    <title>My JSP 'userAdmin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
   	
   	  	
    	<center>
    		<h3>用户主页</h3>
    		<a href="addUser.jsp">添加用户</a>
    		<table border="1">
    			<tr>
    				<th>用户ID</th>
    				<th>用户姓名</th>
    				<th>用户密码</th>
    				<th>用户性别</th>
    				<th>用户生日</th>
    				<th>是否启用</th>
    				<th>操作</th>
    			</tr>
	    		<s:iterator value="userList" var="emp">
	    			<tr>
	    				<td> <s:property value="#emp.id" /> </td>
	    				<td> <s:property value="#emp.name" /> </td>
	    				<td> <s:property value="#emp.pwd" /> </td>
	    				<td> <s:property value='#emp.sex == "M"?"男":"女" '/> </td>
	    				<td> <s:property value="#emp.birth" /> </td>
	    				<td> <s:property value="#emp.isActive" /> </td>
	    				<td>
	    					<s:a href="UserAction_findUser?employee.id=%{#emp.id}">修改</s:a>
	    					<s:a href="javascript:checkDelete(%{#emp.id})">删除</s:a>
	    				</td>
	    			</tr>	
	    		</s:iterator>
    		
    		</table>
    		
    	</center>
  </body>
  <script type="text/javascript">
  		function checkDelete(a){
  			if(confirm("你确定要删除么?")){
  				location="UserAction_deleteUser?employee.id="+a;
  			}
  		}
  </script>
</html>
