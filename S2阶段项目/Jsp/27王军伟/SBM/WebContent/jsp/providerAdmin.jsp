<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../css/style.css">
<script type="text/javascript">
	function doit(flag, id) {
		if (flag == "del") {
			if (confirm("确认删除吗？") != true)
				return;
		}
		window.location = "provider.do?id=" + id + "&flag=" + flag;
	}
</script>
</head>
<body>
	<div class="menu">
		<table>
			<tr>
				<td><form method="post" action="../provide?cmd=query">
						供应商名称： <input name="providername" class="input-text" type="text">
						&nbsp;&nbsp;&nbsp;&nbsp; 供应商描述： <input name="providerdetail"
							class="input-text" type="text"> &nbsp;&nbsp;&nbsp;&nbsp;
						<input class="button" value="组 合 查 询" type="submit">
					</form></td>
			</tr>
		</table>
	</div>
	<div class="main">
		<div class="optitle clearfix">
			<em><input value="添加数据" class="input-button"
				onclick="window.location='providerAdd.jsp'" type="button"></em>
			<div class="title">供应商管理&gt;&gt;</div>
		</div>

		<div class="content">
			<table class="list">
				<tbody>
					<tr>
						<th width="70" height="29"><div class="STYLE1" align="center">编号</div></th>
						<th width="80"><div class="STYLE1" align="center">供应商名称</div></th>
						<th width="100"><div class="STYLE1" align="center">供应商描述</div></th>
						<th width="100"><div class="STYLE1" align="center">联系人</div></th>
						<th width="100"><div class="STYLE1" align="center">电话</div></th>
						<th width="100"><div class="STYLE1" align="center">传真</div></th>
						<th width="100"><div class="STYLE1" align="center">地址</div></th>
						<th width="100"><div class="STYLE1" align="center">操作</div></th>
					</tr>
					<c:forEach items="${providers.data}" var="provider">
						<tr>
							<td width="70" height="29"><div class="STYLE1"
									align="center">${provider.providerid}</div></td>
							<td width="80"><div class="STYLE1" align="center">${provider.providername}</div></td>
							<td width="100"><div class="STYLE1" align="center">${provider.providerdetail}</div></td>
							<td width="100"><div class="STYLE1" align="center">${provider.contact}</div></td>
							<td width="100"><div class="STYLE1" align="center">${provider.telephone}</div></td>
							<td width="100"><div class="STYLE1" align="center">${provider.facsimile}</div></td>
							<td width="100"><div class="STYLE1" align="center">${provider.address}</div></td>
							<td width="100"><a
								href="updateProvider.jsp?providerid=${provider.providerid}">修改/删除</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<form id="form" method="post" action="provide?cmd=getPageBean">
			<label class="input-button">跳转到</label> <select name="p"
				onchange="getPageBeanByP();">
				<c:forEach var="j" begin="1" end="${providers.pagetotal}">
					<c:if test="${providers.p == j}">
						<option selected="selected" value="${j}">第${j}页</option>
					</c:if>
					<c:if test="${providers.getP() != j}">
						<option value="${j}">第${j}页</option>
					</c:if>
				</c:forEach>
			</select> <a class="input-button"
				href="../provide?cmd=getPageBean&&p=${providers.p - 1 }">上一页</a> <a
				class="input-button"
				href="../provide?cmd=getPageBean&&p=${providers.p + 1 }">下一页</a>
		</form>
	</div>
</body>
</html>