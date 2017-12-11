<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>超市账单管理系统</title>
<link rel="stylesheet" href="../css/style.css" />
</head>
<frameset rows="100,*" cols="*" frameborder="no" border="0"
	framespacing="0">
	<frame src="jsp/admin_top.jsp" name="topFrame" scrolling="No"
		noresize="noresize" id="topFrame" />
	<frameset cols="200,*" frameborder="no" border="0" framespacing="0">
		<frame src="jsp/admin_left.jsp" name="leftFrame" scrolling="No"
			noresize="noresize" id="leftFrame" />
		<frame src="jsp/admin_bill_list.jsp" name="mainFrame" id="mainFrame" />
	</frameset>
</frameset>
<noframes>
	<body>
	</body>
</noframes>
</html>
