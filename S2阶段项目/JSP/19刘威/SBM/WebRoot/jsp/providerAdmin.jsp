<%@page import="com.liuwei.sbm.conmon.bean.PageBean"%>
<%@page import="com.liuwei.sbm.provider.bean.Provider" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@  %>

<html xmlns="http://www.w3.org/1999/xhtml">

<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript">
function doit(flag,id)
{
	if(flag=="del")
	{
		if(confirm("确认删除吗？")!=true)
			return;
	}
	window.location = "provider.do?id="+id+"&flag="+flag;
}
</script>
</head>
<body>
<div class="menu">

<table>
<tbody><tr><td><form method="post"  name="frm" >
<input name="cmd" value="search" type="hidden">
供应商名称：<input name="providerName" class="input-text" type="text"> &nbsp;&nbsp;&nbsp;&nbsp;供应商描述：<input name="providerDesc" class="input-text" type="text">&nbsp;&nbsp;&nbsp;&nbsp;<input value="组 合 查 询" onclick="toPage(1)" type="submit">
</form></td></tr>
</tbody></table>
</div>
<div class="main">
<div class="optitle clearfix">
<em><input value="添加数据" class="input-button" onclick="window.location='providerAdd.jsp'" type="button"></em>
		<div class="title">供应商管理&gt;&gt;</div>
	</div>
       
<div class="content">
<table class="list">
<tr>
				<td>编号</td>
				<td>供应商名称</td>
				<td>供应商描述</td>
				<td>联系人</td>
				<td>电话</td>
				<td>地址</td>
			
</tr>
   <% 
			  PageBean pb=(PageBean)request.getAttribute("pb");
   			   List tacts=pb.getData();
			   for(int i=0;i<tacts.size();i++){
	        	Provider p=(Provider)tacts.get(i);
			 %>	
  <tr>
    <td><%=p.getProviderId() %></td>
    <td><a href="provider?cmd=Providerinfo&proId=<%=p.getProviderId()%>"><%=p.getProviderName() %></a></td>
    <td><%=p.getProviderDetail()%></td>
    <td><%=p.getContact() %></td>
    <td><%=p.getTelephone()%></td>
    <td><%=p.getAddress()%></td>
  </tr>
  
<%}%>
</table>
	</div>
	
</div> &nbsp;&nbsp;
<a href="javascript:toPage(1);">首页</a>
<a href="javascript:toPage(<%=pb.getP()-1%>);">上一页</a>
<a href="javascript:toPage(<%=pb.getP()+1%>);">下一页</a>
<a href="javascript:toPage(<%=pb.getPagetotal()%>);">尾页</a>&nbsp;
跳到第:
<select id="secpage" onchange=toPage(this.value)>
	<script language="javascript">
		function toPage(a){
			document.frm.action="serv?p="+a;
			document.frm.submit();
		}
		for(i=1;i<=<%=pb.getPagetotal()%>;i++){
			document.write("<option value="+i+">"+i+"</option>");
		}
		document.getElementById("secpage").value=<%=pb.getP()%>
	</script>
</select>页

</body></html>