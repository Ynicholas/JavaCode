<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:useBean id="student" class="cn.zyf.Student" scope="session">
	<jsp:setProperty name="student" property="*"/>
</jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>张英锋-20160310112</title>
</head>
<body>
	<h4>显示客户信息如下</h4>
	<table border="1">
		<tr>
			<td>姓名：</td>
			<td><jsp:getProperty property="sname" name="student"/></td>
		</tr>
		<tr>
			<td>学号：</td>
			<td><jsp:getProperty property="sno" name="student"/></td>
		</tr>
		<tr>
			<td>成绩：</td>
			<td><jsp:getProperty property="grade" name="student"/></td>
		</tr>
	</table>
	<a href="Luru.jsp">回到首页</a>
</body>
</html>