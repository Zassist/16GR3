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
<div>
<s:form action="file_upload" method="post" enctype="multipart/form-data">
<s:textfield label="姓名" name="uname"/>
<s:file label="挑选文件" name="UploadFile"/>
<s:submit value="提交"/>
</s:form>
<s:fielderror/>
<s:actionerror/>
</div>
</body>
</html>