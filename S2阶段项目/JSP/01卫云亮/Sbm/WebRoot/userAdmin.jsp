<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html><head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="/zdgl/css/style.css">
<script type="text/javascript">
function doit(flag,id)
{
	if(flag=="del")
	{
		if(confirm("确认删除吗？")!=true)
			return;
	}
}
function tj(v){
	window.location = "/zdgl/user/userServlet?action=${userName!=null ? 'like' : 'all'}&p="+v+"${userName!=null ? '&userName=' : '' }${userName!=null ? userName : ''}";
}
</script>
</head><body>




<div class="menu">
	<table>
		<tbody>
		<tr>
			<td>
				<form method="post" action="/zdgl/user/userServlet">
					<input name="action" value="like" class="input-text" type="hidden">
					用户名称：<input name="userName" value="${userName}" class="input-text" type="text">&nbsp;&nbsp;&nbsp;&nbsp; 
					<input value="查 询" type="submit">
				</form>
			</td>
		</tr>
		</tbody>
	</table>
</div>
<div class="main">
	<div class="optitle clearfix">
	<em><input value="添加数据" class="input-button" onclick="window.location='/zdgl/userAdd.jsp'" type="button"></em>
			<div class="title">用户管理&gt;&gt;</div>
		</div>
		<div class="content">
	<table class="list">
	  <tbody>
		  <tr>
		    <td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
		    <td width="100"><div class="STYLE1" align="center">用户名称</div></td>
		    <td width="100"><div class="STYLE1" align="center">用户头像</div></td>
		    <td width="80"><div class="STYLE1" align="center">性别</div></td>
		    <td width="80"><div class="STYLE1" align="center">年龄</div></td>
		    <td width="120"><div class="STYLE1" align="center">电话 </div></td>
		    <td width="300"><div class="STYLE1" align="center">地址 </div></td>
		    <td width="120"><div class="STYLE1" align="center">权限 </div></td>
		    <td width="120"><div class="STYLE1" align="center">操作</div></td>
		  </tr>
	  <c:forEach items="${pageBean.list}" var="user">
		  <tr>
		    <td height="23"><span class="STYLE1">${user.userId }</span></td>
		    <td><span class="STYLE1"><a href="/zdgl/user/userServlet?action=preUpd&userId=${user.userId }">${user.userName }</a></span></td>
		    <td><span class="STYLE1"><img width="40" height="60" src="/zdgl/${user.pic }"/></span></td>
		    <td><span class="STYLE1">${user.userSex }</span></td>
		    <td><span class="STYLE1">${user.userAge }</span></td>
		    <td><span class="STYLE1">${user.telephone }</span></td>
		    <td><span class="STYLE1">${user.address }</span></td>
		    <td><span class="STYLE1">${user.type==0 ? '员工' : '经理' }</span></td>
		    <td><span class="STYLE1"><a href="/zdgl/user/userServlet?action=del&userId=${user.userId}&pic=${user.pic}" onclick="return confirm('确认删除?')">删除</a></span></td>
		  </tr>
	  </c:forEach>
	</tbody></table>
	<div style="border:1px solid red;text-align: center; font-size: 14px">
		第${pageBean.p}页/共${pageBean.pageTotal}页&nbsp;
		<a href="/zdgl/user/userServlet?action=${userName!=null ? 'like' : 'all'}&p=1${userName!=null ? '&userName=' : '' }${userName!=null ? userName : ''}">首页</a>
		<a href="/zdgl/user/userServlet?action=${userName!=null ? 'like' : 'all'}&p=${pageBean.p-1<=0 ? 1 : pageBean.p-1}${userName!=null ? '&userName=' : '' }${userName!=null ? userName : ''}">上一页</a>
		<a href="/zdgl/user/userServlet?action=${userName!=null ? 'like' : 'all'}&p=${pageBean.p+1>=pageBean.pageTotal ? pageBean.pageTotal : pageBean.p+1 }${userName!=null ? '&userName=' : '' }${userName!=null ? userName : ''}">下一页</a>
		<a href="/zdgl/user/userServlet?action=${userName!=null ? 'like' : 'all'}&p=${pageBean.pageTotal }${userName!=null ? '&userName=' : '' }${userName!=null ? userName : ''}">尾页</a>
		跳转到
		<select onchange="tj(this.value)">
			<c:forEach begin="1" end="${pageBean.pageTotal}" var="p">
				<option ${pageBean.p == p ? 'selected' : '' }>${p}</option>
			</c:forEach>
		</select>
	</div>
	</div>
</div>
</body></html>