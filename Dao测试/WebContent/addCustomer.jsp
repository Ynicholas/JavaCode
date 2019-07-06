<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>张英锋-20160310112</title>
</head>
<body>
	<font color=red>${result}</font>
	<p>请输入一条客户记录</p>
	<form action="addCustomer.do" method="post">
		<table>
			<tr><td>客户号:</td><td><input type="text" name="cust_id"></td></tr>
			<tr><td>客户名:</td><td><input type="text" name="cname"></td></tr>
			<tr><td>Email:</td><td><input type="text" name="email"></td></tr>
			<tr><td>余额:</td><td><input type="text" name="balance"></td></tr>
			<tr><td><input type="submit" value="确定"></td>
				<td><input type="reset" name="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>