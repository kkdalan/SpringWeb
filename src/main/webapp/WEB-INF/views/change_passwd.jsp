<%@ page language="java" contentType="text/html; charset=Big5"
	pageEncoding="Big5"%>

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
	<img src='images/spring.jpg' alt='Spring 線上書籤  Logo' border='0' align='left' valign='botton' />
	<h1>&nbsp;Spring 線上書籤</h1>
	<hr style="width: 100%; height: 2px;">
	<hr style="width: 100%; height: 2px;">
	<br>
	<form method='post' action='member.do'>
		<table width='300' cellpadding='2' cellspacing='0' bgcolor='#cccccc'>
			<tr>
				<td>新密碼：</td>
				<td><input type='password' name='new_passwd' size='16'
					maxlength='16'> <input type='hidden' name='action'
					value='changePasswd'></td>
			</tr>
			<tr>
				<td colspan='2' align='center'></td>
				<td><input type='submit' value="改變密碼" /></td>
			</tr>
		</table>
		<br>
	</form>
	<hr style="width: 100%; height: 2px;">
     <a href='member.do'>會員首頁</a>&nbsp;&nbsp;
     <a href='member.do?action=addUrl'>加入書籤</a>&nbsp;&nbsp;
     <a href='member.do?action=changePasswd'>改變密碼</a>&nbsp;&nbsp;
     <a href='member.do?action=logout'>登出</a>&nbsp;&nbsp;
     <hr style="width: 100%; height: 2px;">
</body>
</html>

