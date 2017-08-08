<%@ page language="java" contentType="text/html; charset=Big5"
	pageEncoding="Big5"%>
<%@ taglib prefix="ezpay" tagdir="/WEB-INF/tags"%>
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
	<img src='/resources/images/spring.jpg' alt='Spring 線上書籤  Logo' border='0' align='left'  />
	<h1>&nbsp;Spring 線上書籤</h1>
	<hr style="width: 100%; height: 2px;">
	<hr style="width: 100%; height: 2px;">
	<ul>
		<li>線上儲存您的書籤 &nbsp;&nbsp;
		<li>分享您我的書籤 &nbsp;&nbsp;
		<li>快來秀出最酷的鏈結
	</ul>
	<a href='register.do'>還不是會員?</a>
	<p>
	<form method='post' action='login.do'>
		<spring:bind path='command.*'>
			<font color="red"> <b>${status.errorMessage}</b></font>
			<br>
		</spring:bind>
		<table bgcolor=#cccccc>
			<tr>
				<td colspan='2'>會員登入</td>
			</tr>
			<tr>
				<td>名稱：</td>
				<td><spring:bind path='command.username'>
						<input type='text' name='${status.expression}'
							value='${status.value}'>
					</spring:bind></td>
			</tr>
			<tr>
				<td>密碼：</td>
				<td><spring:bind path='command.passwd'>
						<input type='password' name='${status.expression}'
							value='${status.value}'>
					</spring:bind></td>
			</tr>
			<tr>
				<td colspan='2' align='center'><input type='submit' value='登入'>
				</td>
			</tr>
			<tr>
				<td colspan='2'><a href='forgot.do'>忘記密碼?</a></td>
			</tr>
		</table>
	</form>
	<a href='/SpringWeb/files_show.do'>檔案管理介面</a>
</body>
</html>

