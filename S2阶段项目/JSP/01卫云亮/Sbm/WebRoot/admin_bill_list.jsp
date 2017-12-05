<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="/zdgl/css/style.css" />
</head>
<body>
<div class="menu">
	<form method="get" action="">
		商品名称：<input type="text" name="productName" class="input-text" />&nbsp;&nbsp;&nbsp;&nbsp;
		是否付款：<select name="payStatus">
			<option value="">请选择</option>
			<option value="1">已付款</option>
			<option value="0">未付款</option>
		</select>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="submit" value="组合查询" class="button" />
	</form>
</div>
<div class="main">
	<div class="optitle clearfix">
		<em><input type="button" name="button" value="添加数据" class="input-button" onclick="location.href='/zdgl/account/accountServlet?action=preAdd'" /></em>
		<div class="title">账单管理&gt;&gt;</div>
	</div>
	<div class="content">
		<table class="list">
			<tr>
				<td>账单编号</td>
				<td>商品名称</td>
				<td>商品数量</td>
				<td>交易金额</td>
				<td>是否付款</td>
				<td>供应商名称</td>
				<td>商品描述</td>
				<td>账单时间</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${pageBean.list}" var="account">
			  <tr>
			    <td height="23"><span class="STYLE1">${account.accountId}</span></td>
			    <td><span class="STYLE1">${account.goodsName}</span></td>
			    <td><span class="STYLE1">${account.businessNum }</span></td>
			    <td><span class="STYLE1">${account.totalPrice }</span></td>
			    <td><span class="STYLE1">${account.isPayed==1 ? '已付款' : '未付款' }</span></td>
			    <td><span class="STYLE1">${account.providerName}</span></td>
			    <td><span class="STYLE1">${account.goodsIntro}</span></td>
			    <td><span class="STYLE1">${account.accountDate }</span></td>
			    <td>
			    	<span class="STYLE1">
			    		<a href="/zdgl/account/accountServlet?action=del&accountId=${account.accountId}" onclick="return confirm('确认删除?')">删除</a>
			    		<a href="/zdgl/account/accountServlet?action=preUpd&accountId=${account.accountId}" onclick="return confirm('确认修改?')">修改</a>
			    	</span>
			    </td>
			  </tr>
	  </c:forEach>
		</table>
		<div style="border:1px solid red;text-align: center; font-size: 14px">
		第${pageBean.p}页/共${pageBean.pageTotal}页&nbsp;
		<a href="/zdgl/account/accountServlet?action=sel&p=1${userName!=null ? '&userName=' : '' }${userName!=null ? userName : ''}">首页</a>
		<a href="/zdgl/account/accountServlet?action=sel&p=${pageBean.p-1<=0 ? 1 : pageBean.p-1}${userName!=null ? '&userName=' : '' }${userName!=null ? userName : ''}">上一页</a>
		<a href="/zdgl/account/accountServlet?action=sel&p=${pageBean.p+1>=pageBean.pageTotal ? pageBean.pageTotal : pageBean.p+1 }${userName!=null ? '&userName=' : '' }${userName!=null ? userName : ''}">下一页</a>
		<a href="/zdgl/account/accountServlet?action=sel&p=${pageBean.pageTotal }${userName!=null ? '&userName=' : '' }${userName!=null ? userName : ''}">尾页</a>
		跳转到
		<select onchange="tj(this.value)">
			<c:forEach begin="1" end="${pageBean.pageTotal}" var="p">
				<option ${pageBean.p == p ? 'selected' : '' }>${p}</option>
			</c:forEach>
		</select>
	</div>
	</div>
</div>
</body>
</html>
