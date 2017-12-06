<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'listemp.jsp' starting page</title>
    
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
  <form action="empAction!listEmp.action" method="post">
  <table width="650">
  <tr>
  	<td colspan="7">
  		请输入姓名:<input type="text" name="emp.ename" size="15">
  		职位:<input type="text" name="emp.job" size="15">
  		所属部门:
  		<s:select list="dlist" 
  		name="emp.did" 
  		listKey="did" 
  		listValue="dname" 
  		headerKey="0" 
  		headerValue="请选择" theme="simple"></s:select>
  	<input type="submit" value="查询">
  	</td>
  </tr>
  	<tr>
  		<td>编号</td>
  		<td>姓名</td>
  		<td>性别</td>
  		<td>职位</td>
  		<td>薪水</td>
  		<td>所属部门</td>
  		<td>操作</td>  		
  	</tr>
  	<s:iterator value="elist">
  		 	<tr>
  		<td><s:property value="eid"/></td>
  		<td><s:property value="ename"/></td>
  		<td><s:property value="sex"/></td>
  		<td><s:property value="job"/></td>
  		<td><s:property value="sal"/></td>
  		<td><s:property value="dname"/></td>
  		<td>
  		<a href="empAction!toUpdateEmp.action?emp.eid=<s:property value='eid'/>"> 修改</a>
  		<a href="empAction!delEmp.action?emp.eid=<s:property value='eid'/>"> 删除</a>
  		
  		</td>  		
  	</tr>
  	
  	</s:iterator>
  </table>
    </form>
  </body>
</html>
