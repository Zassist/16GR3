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
    
    <title>My JSP 'allFiles.jsp' starting page</title>
    
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
   上传者： ${username}
    <Br>
  文件名：${uploadFileFileName }
  <br>
  文件类型：${uploadFileContentType}<Br>
  ----------------------------------------------------------------
  下载：<br>
 下载1:<a href="/Struts7/upload/${uploadFileFileName }">${uploadFileFileName }</a><br>
 下载2:<s:a href="/Struts7/file!download?downfile_name=%{uploadFileFileName }">${uploadFileFileName }</s:a>
  </body>
</html>
