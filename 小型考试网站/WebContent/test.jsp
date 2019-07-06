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
	<p>请回答下面的问题</p>
	<form action="./testServlet" method="post">
		<p>1.下面哪个方法不是Servlet声明周期方法？</p>
			<input type="radio" name="quest1" value="1">public void destroy()<br>
			<input type="radio" name="quest1" value="2">public void service()<br>
			<input type="radio" name="quest1" value="3">public ServletConfig getServletConfig()<br>
			<input type="radio" name="quest1" value="4">public void init()<br>
		<p>2。要使向服务器发送的数据不在浏览器的地址栏中显示，应该使用什么方法？</p>
			<input type="radio" name="quest2" value="1">POST<br>
			<input type="radio" name="quest2" value="2">GET<br>
			<input type="radio" name="quest2" value="3">PUT<br>
			<input type="radio" name="quest2" value="4">HEAD<br>
		<p>3.考虑到下面的html页面代码：&lt;a href = "/HelloServlet"&gt;请求&lt;/a&gt; 当用户在显示的超链接上单击时将调用HelloServlet
		的哪个方法？</p>
			<input type="radio" name="quest3" value="1">doPost()<br>
			<input type="radio" name="quest3" value="2">doGet()<br>
			<input type="radio" name="quest3" value="3">doForm()<br>
			<input type="radio" name="quest3" value="4">doHref()<br>
		<p>4.将严格Student类的对象student用名称studobj存储到请求作用域中，下面代码哪个是正确的？</p>
			<input type="radio" name="quest4" value="1">request.setAttribute("student",studobj)<br>
			<input type="radio" name="quest4" value="2">request.andAttribute("student",studobj)<br>
			<input type="radio" name="quest4" value="3">request.setAttribute("studobj",student)<br>
			<input type="radio" name="quest4" value="4">request.getAttribute("studobj",studend)<br>
		<p>5。如果需要向浏览器发送一个GIG文件，何时调用response,getOutputStream()？</p>
			<input type="radio" name="quest5" value="1">PrintWriter out = response.getServletOutput();<br>
			<input type="radio" name="quest5" value="2">PrintWriter out = response.getPrintWriter();<br>
			<input type="radio" name="quest5" value="3">OutputStream out = response.getWriter();<br>
			<input type="radio" name="quest5" value="4">OutputStream out = response.getOutputStream()<br>
		<p>交卷请点击：<input type="submit" value="交卷"><br>
		重答请点击：<input type="reset" value="重答">
	</form>
</body>
</html>