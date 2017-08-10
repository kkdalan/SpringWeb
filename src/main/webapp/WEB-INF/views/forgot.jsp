<%@ page language="java" contentType="text/html; charset=Big5"
	pageEncoding="Big5"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<title>Spring 線上書籤</title>
<style>
body {
	font-family: Ariel, Helvetica, sans-serif;
	font-size: 13px
}

li, td {
	font-family: Ariel, Helvetica, sans-serif;
	font-size: 13px
}

hr {
	color: #3333cc;
	width: 300;
	text-aligh: left
}

a {
	color: #000000
}
</style>
</head>
<body>
	<img src='images/spring.jpg' alt='Spring 線上書籤  Logo' border='0'
		align='left' valign='botton' />
	<h1>&nbsp;Spring 線上書籤</h1>
	<hr style="width: 100%; height: 2px;">
	<hr style="width: 100%; height: 2px;">
	<br>
	<form method='post' action='forgot.do'>
		<table width='250' cellpadding='2' cellspacing='0' bgcolor=#cccccc>
			<tr>
				<td>輸入郵件地址：</td>
				<td><input type='text' name='email' size='16' maxlength='100'></td>
			</tr>
			<tr>
				<td colspan='2' align='center'><input type='submit'
					value='寄出密碼'></td>
			</tr>
		</table>
	</form>
	<br>
</body>
</html>

