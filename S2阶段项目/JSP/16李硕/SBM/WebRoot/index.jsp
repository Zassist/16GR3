<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<title>系统登录 - 超市账单管理系统</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
  </head>
  

<body class="blue-style">
<c:if test="${param.loginMsg eq 'failed'}">
		<script type="text/javascript">
			alert("用户名或密码错误！登录失败！");
		</script>
	</c:if>
<div id="login">
	<div class="icon"></div>
	<div class="login-box">	
		<form method="post" action="user?cmd=login" id="formLogin"> 
			<dl>
				<dt>用户名：</dt>
				<dd><input type="text" id="userName" name="userName" class="input-text" /></dd>
				<dt>密　码：</dt>
				<dd><input type="password" id="password" name="userPassword" class="input-text" /></dd>
			</dl>
			<div class="buttons">
				<input type="button" name="button" value="登录系统" class="input-button" onclick="loginCheck()" />
				<input type="reset" name="reset" value="重　　填" class="input-button" />
			</div>
		</form>
	</div>
</div>
<script type="text/javascript">
function loginCheck(){
      var formLogin = document.getElementById("formLogin");
	  var name=document.getElementById("userName").value;
	  var pwd=document.getElementById("userPassword").value;
	  if(name != null && name != "" && pwd != null && pwd != ""){
		  formLogin.submit();
	  }else{
		  alert("用户名或密码不能为空!");
	  }
}
  
</script>
</body>
</html>
