<%@ page language="java"  contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>张英锋-20160310112</title>
</head>
<script type="text/javascript">
	$(function(){
		$("#liebiao").blur(function(){
			
		})
	})
</script>
<% String[] filename=(String[])request.getAttribute("filename"); %>
<body>
	${message1}<br>
	<form action="./FileDownload" enctype="multipart/form-data" method="post">
		<table>
			<tr><td>文件下载(点击下载)</td></tr>
			<tr><td>文件列表：</td></tr>
			<%
			int i=0;
			for(i=0;i<filename.length;i++){ 
			%>
			<tr>	
				<td><a href="./FileDownloadServlet?filename=<%out.print(filename[i]); %>"><%out.print(filename[i]); %></a></td>
			</tr>
			<%} %>
		</table>
	</form>
	<br><a href="./function.jsp">回到首页</a>
</body>
</html>