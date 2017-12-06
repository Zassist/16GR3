<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.liuwei.sbm.provider.bean.Provider" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'providerinfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="css/style.css" />
  </head>
  
    <body>
   <div class="main">
	<div class="optitle clearfix">	
		<div class="title">账单管理&gt;&gt;</div>
	</div>
	<form method="post"  name="frm">
	<input type="hidden" name="cmd" value="updateProvider"/>

		<div class="content">
	
			<table class="box">
		
			<%
			Provider pro= (Provider)request.getSession().getAttribute("a");
			
			
			 %>
				
				
				<tr>
					<td class="field">供应商编号：</td>
					<td><input type="text" name="ProviderId" class="text" value="<%=pro.getProviderId()%>" /></td>
				</tr>
				
				
				<tr>
					<td class="field">供应商名称：</td>
					<td><input type="text" name="ProviderName" class="text" value="<%=pro.getProviderName()%>" /></td>
				</tr>
				
				
					<tr>
					<td class="field">供应商描述：</td>
					<td><input type="text" name="ProviderDeil" class="text"  value="<%=pro.getProviderDetail()%>" /></td>
				   </tr>
				   
				   	<tr>
				
					<td class="field" >供应商联系人：</td>
					<td><input type="text" name="ProviderPerson" class="text"  value="<%=pro.getContact()%>" /></td>
				   </tr>
				   
				   	<tr>
				
					<td class="field" >供应商电话：</td>
					<td><input type="text" name="ProviderPhone" class="text" value="<%=pro.getTelephone()%>" /></td>
				   </tr>
			
			
					<tr>
					<td class="field">供应商传真：</td>
					<td><input type="text" name="ProviderFa" class="text"   value="<%=pro.getFacsimile()%>"/></td>
				   </tr>
				
					<tr>
					<td class="field">供应商地址：</td>
					<td><input type="text" name="providrAddress" class="text"  value="<%=pro.getAddress()%>" /></td>
				   </tr>
				
			
		
			
			
			</table>
		</div>
		<div class="buttons">
					
			<input type="button" name="button" value="返回" class="input-button" onclick="history.back();" />
			<input type="submit" name="submit" value="修改" class="input-button"  onclick="updateProvider()"  />
			<input type="submit" name="submit" value="删除" class="input-button"  onclick="deleteProvider()"/>
		</div>
		
	<script language="javascript">
		function updateProvider(){
			document.frm.action="serv?cmd=updateProvider";
			document.frm.submit();
		}
				
	</script>
	
	<script language="javascript">
		function deleteProvider(){
			document.frm.action="serv?cmd=deleteProvider&&deleteid=<%=pro.getProviderId()%>";
			document.frm.submit();
		}
		
		
	</script>
			
	</form>
</div>
  </body>
</html>
