<%@page import="dao.LoginDaoIMP"%>
<%@page import="bean.tb_account"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
tb_account account =new tb_account();

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
	<form method="post">
	
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
		<div class="title">账单管理&gt;&gt;</div>
	</div>
	<form method="post" action="zhangdan" >
	
		<div class="content">
			<table class="box">
			<%int accountId=Integer.parseInt(request.getParameter("accountId"));
			
  
   %>
   <input type="hidden" name="cmd" value="xiugai">
	<input type="hidden" name="bianhao" value=<%=accountId %>>
   
   <h2>您要修改的账单编号为：<%=accountId %></h2>
				<% 
				account= LoginDaoIMP.chaxunzhangdan(accountId);
				account.getGoodsName();
				
				 %>
				<tr>
					<td class="field">商品名称：</td>
					<td><input type="text" name="goodsName" class="text" value=<%=account.getGoodsName() %>></td>
				</tr>
				<tr>
					<td class="field">交易数量：</td>
					<td><input type="text" name="businessNum" class="text" /></td>
				</tr>
				<tr>
					<td class="field">交易金额：</td>
					<td><input type="text" name="totalPrice" class="text" /></td>
				</tr>
				<tr>
					<td class="field">供应商名称：</td>
					<td><input type="text" name="providerName" class="text" /></td>
				</tr>
				<tr>
					<td class="field">账单时间：</td>
					<td><input type="text" name="accountDate" class="text" /></td>
				</tr>
				
				<tr>
					<td class="field">是否付款：</td>
					<td><select name="isPayed">
						<option value="1">是</option>
                        <option value="2">否</option>
					</select></td>
				</tr>
			</table>
		</div>
		<div class="buttons">
			<input type="submit" name="submit" value="确认" class="input-button" />
			<input type="button" name="button" value="返回" class="input-button" onclick="history.back();" />
		</div>
	</form>
</div>
</body>
</html>
