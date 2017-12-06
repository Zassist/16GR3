<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
您的名字：${uname }<br>
上传文件名字：${UploadFileFileName}<br>
上传文件类型：${UploadFileContentType}<br>
上传文件大小：<s:property value="UploadFile.length()"/>字节<br>
<h2 align="center">下载</h2><br>
<s:a href="struts2T07/file_download?downloadname=%{UploadFileFileName}">点击下载</s:a>
</body>
</html>