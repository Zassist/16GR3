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
    
    <title>My JSP 'updateemp.jsp' starting page</title>
    
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
     <s:form action="empAction!updateEmp.action" method="post" >   
     	<s:hidden name="emp.eid"></s:hidden>
   		<s:textfield name="emp.ename" label="����"></s:textfield>   		
   		<s:textfield name="emp.job" label="ְλ"></s:textfield>
   		<s:radio list="#{'F':'Ů','M':'��'}" name="emp.sex" label="�Ա�"></s:radio>
   		<s:textfield name="emp.sal" label="нˮ"></s:textfield>   		
   		<s:select list="#session.dlist" name="emp.did" listKey="did"  label="��������" listValue="dname"></s:select>
   		<s:submit value="�޸�"></s:submit>   		
   </s:form>
  </body>
</html>
