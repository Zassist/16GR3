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
  		����������:<input type="text" name="emp.ename" size="15">
  		ְλ:<input type="text" name="emp.job" size="15">
  		��������:
  		<s:select list="dlist" 
  		name="emp.did" 
  		listKey="did" 
  		listValue="dname" 
  		headerKey="0" 
  		headerValue="��ѡ��" theme="simple"></s:select>
  	<input type="submit" value="��ѯ">
  	</td>
  </tr>
  	<tr>
  		<td>���</td>
  		<td>����</td>
  		<td>�Ա�</td>
  		<td>ְλ</td>
  		<td>нˮ</td>
  		<td>��������</td>
  		<td>����</td>  		
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
  		<a href="empAction!toUpdateEmp.action?emp.eid=<s:property value='eid'/>"> �޸�</a>
  		<a href="empAction!delEmp.action?emp.eid=<s:property value='eid'/>"> ɾ��</a>
  		
  		</td>  		
  	</tr>
  	
  	</s:iterator>
  </table>
    </form>
  </body>
</html>
