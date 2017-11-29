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
  <p style="color: pink">
      <s:property value="content"/>  
      <!-- 显示回应给用户的数据，其中value属性指定的就是HelloAction组件中定义的content属性名 -->
  </p>
  <p style="color: blue">
      ${content}
      <!-- 也可以使用EL表达式显示回应的数据 -->
  </p>
</body>
</html>