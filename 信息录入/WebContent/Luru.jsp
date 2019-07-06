<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>张英锋-20160310112</title>
</head>
<body>
	<h4>输入客户信息</h4>
	<form action="./StudentServlet" method="post">
		<table>
			<tr><td>姓名</td><td><input type="text" name="sname"></td></tr>
			<tr><td>学号</td><td><input type="text" name="sno"></td></tr>
			<tr><td>成绩</td><td><input type="text" name="grade"></td></tr>
			<tr>
				<td><input type="submit" value="确定"></td>
				<td><input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>