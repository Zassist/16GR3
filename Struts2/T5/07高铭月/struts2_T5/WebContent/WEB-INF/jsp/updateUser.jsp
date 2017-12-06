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

<h2 align="center">toUpdate页面</h2>

<div align="center">

  <s:form id="updateUserForm" action="skip/user_updateUser" method="post">

  <s:hidden name="user.id" ></s:hidden>

  <s:textfield label="名字" name="user.uname"></s:textfield>

  <s:password label="密码" name="user.upwd"></s:password>

  <s:textfield label="生日" name="user.birthday"></s:textfield>

  <s:radio id="sexradio" label="性别" name="user.sex" list="#{'M':'男','F':'女' }" value="user.sex" ></s:radio>

  <s:radio id="uenableradio" label="是否启用" name="user.uenable" list="#{0:'否',1:'是' }" value="user.uenable"></s:radio>

  </s:form>

  <input type="button" value="提交"  onclick="action();">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;

  <input type="button" value="返回" onclick="Go();">

</div>

<script type="text/javascript">

function Go(){

	 window.history.go(-1);

}

function action(){

	 var updateUserForm=document.getElementById("updateUserForm");

	 updateUserForm.submit();

}

</script>

</body>

</html>