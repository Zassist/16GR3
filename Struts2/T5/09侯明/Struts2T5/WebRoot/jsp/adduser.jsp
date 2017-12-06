<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adduser.jsp' starting page</title>
    
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
    <h2 align="center">addUser页面</h2>
    <div align="center">
	  <s:form id="adduserForm" action="/skip/user_addUser" method="post">
	  <s:textfield label="名字" name="user.uname"></s:textfield>
	  <s:password label="密码" name="user.upwd"></s:password>
	  <s:textfield label="生日" name="user.birthday"></s:textfield>
	  <s:radio label="性别" name="user.sex" list="#{'M':'男','F':'女' }" value='"M"'></s:radio>
	  <s:radio label="是否启用" name="user.uenable" list="#{0:'否',1:'是' }" value="0"></s:radio>
	  </s:form>
  <input type="button" value="提交" onclick="action();">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
  <input type="button" value="返回" onclick="Go();">
</div>
	<script type="text/javascript">
		function Go(){
			 window.history.go(-1);
		}
		
		function action(){
			 var adduserForm=document.getElementById("adduserForm");
			 adduserForm.submit();
		}
	</script>
  </body>
</html>
