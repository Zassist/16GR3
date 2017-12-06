<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="/zdgl/css/style.css">
<script type="text/javascript">
function checkit()
{
	//判断是否是数字的正则表达式
	return true;
}
</script>
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">用户管理&gt;&gt;</div>

	</div>
	<form id="form1" name="form1" method="post" action="/zdgl/user/userServlet?action=${requestScope.user==null ? 'add' : 'upd' }" onsubmit="return checkit();" enctype="multipart/form-data">
		<c:if test="${requestScope.user != null }">
			<input type="hidden" name="userId" value="${requestScope.user.userId }" id="textfield" class="text"/>
		</c:if>
		<div class="content">
			<table class="box"><font color="red"></font>
				<tr>
					<td class="field">用户名称：</td>
					<td><input type="text" name="userName" value = "${requestScope.user.userName }" class="text" id="textfield2" /> <font color="red">*</font></td>
				</tr>
				<c:if test="${requestScope.user==null}">
					<tr>
						<td class="field">用户密码：</td>
						<td><input type="password" name="userPassword1" class="text" id="textfield2" /> <font color="red">*</font></td>
					</tr>
					<tr>
						<td class="field">确认密码：</td>
						<td><input type="password" name="userPassword2" class="text"/> <font color="red">*</font></td>
					</tr>
				</c:if>
				<c:if test="${requestScope.user!=null}">
					<tr>
						<td class="field">原头像：</td>
						<td>
							<img src="/zdgl/${requestScope.user.pic}" width=40 height=60>
						</td>
					</tr>
				</c:if>
				<tr>
					<td class="field">用户头像：</td>
					<td>
						<input type="file" name="file"/>
					</td>
				</tr>
				<tr>
					<td class="field">用户性别：</td>
					<td>
						<select name="userSex" id="select">
    						<option value="女" ${requestScope.user.userSex == '女' ? 'selected' : '' }>女</option>
    						<option value="男" ${requestScope.user.userSex == '男' ? 'selected' : '' }>男</option>
  						</select>
  					</td>
				</tr>
				<tr>
					<td class="field">用户年龄：</td>
					<td><input type="text" name="userAge" value="${requestScope.user.userAge}" class="text" id="textfield2"/> <font color="red">*</font></td>
				</tr>
				<tr>
					<td class="field">用户电话：</td>
					<td><input type="text" name="telephone" value="${requestScope.user.telephone }" class="text" id="textfield2"/> <font color="red">*</font></td>
				</tr>
				<tr>
					<td class="field">用户地址：</td>
					<td><input name="address" type="text" value="${requestScope.user.address }" class="text"/></td>
				</tr>
				<tr>
					<td class="field">用户权限：</td>
					<td>
						<input type="radio" name="type" id="auth" value="0" ${requestScope.user==null ? 'checked' : ''} ${requestScope.user.type==0 ? 'checked' : '' }/>员工
						<input type="radio" name="type" id="auth" value="1" ${requestScope.user.type==1 ? 'checked' : ''}  />经理
					</td>
				</tr>
			</table>
		</div>
		<div class="buttons">
			<input type="submit" name="button" id="button" value="${requestScope.user==null ? '添加' : '修改'}" class="input-button"/>
			<input type="button" name="button" id="button" onclick="window.location='/zdgl/user/userServlet?action=all';" value="返回" class="input-button"/> 
		</div>
	</form>
</div>
</body>
</html>
