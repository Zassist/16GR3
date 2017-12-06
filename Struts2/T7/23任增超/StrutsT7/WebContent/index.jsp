<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:form action="file!upload" method="post" enctype="multipart/form-data">
		<s:textfield label="用户名" name="userName"/>
		<s:file label="请选择上传的文件" name="uploadfile"/>
		<s:submit value="上传"/>
	</s:form>
</body>
</html>