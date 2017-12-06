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
    
    <title>My JSP 'addemp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <s:head/>
  <body>
   <s:form action="empAction!addEmp.action" method="post" >   
   		<s:textfield name="emp.ename" label="姓名"></s:textfield>   		
   		<s:textfield name="emp.job" label="职位"></s:textfield>
   		<s:radio list="#{'F':'女','M':'男'}" name="emp.sex" label="性别"></s:radio>
   		<s:textfield name="emp.sal" label="薪水"></s:textfield>
   		<!-- ????  	
   		name="emp.did" 控件名
   				 -->
   		<s:select list="#session.dlist" name="emp.did" listKey="did"  label="所属部门" listValue="dname"></s:select>
   		<s:submit value="保存"></s:submit>   		
   </s:form>
  </body>
</html>
