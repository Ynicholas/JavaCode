<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>张英锋-20160310112</title>
</head>
<body>
${sessionScope.message}<br>
	<!-- <form action="./dengluServlet" method="post"> -->
	<form action="./CheckUserServlet" method="post">
		昵称：<input type="text"  name="username">
		密码：<input type="password"  name="password">
		<input type="checkbox" name="check" value="check"/>自动登录<br>
		<input type="submit" name="submit" value="登陆">
	</form>
	<a href="zhuce.jsp">注册</a>
</body>
</html>