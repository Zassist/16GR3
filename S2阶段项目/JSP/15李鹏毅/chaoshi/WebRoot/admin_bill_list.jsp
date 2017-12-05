<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="bean.PageBean"%>
<%@page import="bean.tb_account"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<div class="menu">
	<form method="post" action="login">
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
		<em><input type="button" name="button" value="添加数据" class="input-button" onclick="location.href='modify.jsp'" /></em>
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
			</tr>
			<%
         PageBean pageBean = (PageBean)session.getAttribute("pageBean");
       
          for(int i=0;i<pageBean.getData().size();i++){
        	   tb_account tb_account = (tb_account)pageBean.getData().get(i);%>
        	   
        	   <tr>
        	       <td><a href="xiugaizhangdan.jsp?accountId=<%=tb_account.getAccountId() %>"><%= tb_account.getAccountId() %></a></td>
        	       <td><%= tb_account.getGoodsName() %></td>
        	       <td><%= tb_account.getGoodsNum() %></td>
        	       <td><%= tb_account.getTotalPrice() %></td>
        	       <td><%= tb_account.getIsPayed()==1?"已付款":"未付款" %></td>
        	       <td><%= tb_account.getProviderName() %></td>
        	       <td><%= tb_account.getGoodsIntro() %></td>
        	       <%
        	       		Date date = tb_account.getAccountDate();
        	       		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        	        %>
        	       <td><%= sdf.format(date) %></td>
        	   </tr>
          
       <%}%>
		</table><br>
		共<%=pageBean.getCount()%>条记录，
第<%=pageBean.getP()%>页/共<%=pageBean.getPageTotal()%>页&nbsp;
<a href="login?cmd=zhangdanchaxun&p=1">首页</a>
<a href="login?cmd=zhangdanchaxun&p=<%=pageBean.getP()-1%>">上一页</a>
<a href="login?cmd=zhangdanchaxun&p=<%=pageBean.getP()+1%>">下一页</a>
<a href="login?cmd=zhangdanchaxun&p=<%=pageBean.getPageTotal()%>">尾页</a>&nbsp;
	</div>
</div>
</body>
</html>
