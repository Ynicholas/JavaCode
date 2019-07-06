<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>张英锋-20160310112</title>
</head>
<body>
	${message1}<br>
	<form action="./FileUploadServlet" enctype="multipart/form-data" method="post">
		<table>
			<tr><td colspan="2" align="center">文件上传</td></tr>
			
			<tr>
				<td>文件名：</td>
				<td><input type="file" name="fileName" size="30"></td>
			</tr>
			<tr>
				<td align="right"><input type="submit" value="提交"></td>
				<td align="left"><input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
	<br>
	<a href='function.jsp'>回到首页</a>
</body>
</html>