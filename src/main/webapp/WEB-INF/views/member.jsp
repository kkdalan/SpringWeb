<%@ page language="java" contentType="text/html; charset=Big5"
	pageEncoding="Big5"%>
<%@ taglib prefix="ezpay" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	<br>${valid_user}您好：<br>
	<br>
	<form name="bm_table" method='post' action='member.do'>
		<table width='300' cellpadding='2' cellspacing='0'>
			<tr bgcolor='#cccccc'>
				<td><strong>書籤</strong></td>
				<td><strong>刪除?</strong></td>
			</tr>
			<c:forEach var="url" items="${urls}">
				<tr bgcolor='#ffffff'>
					<td><a href=<c:out value="${url}"/>> <c:out value="${url}" /></a></td>
					<td><input type='checkbox' name='del_me'
						value=<c:out value="${url}"/>></td>
				</tr>
			</c:forEach>
			<tr bgcolor='#ffffff'>
				<td></td>
				<td><input type='hidden' name='action' value="deleteUrl" /> <input
					type='submit' value="刪除" /></td>
			</tr>
		</table>
	</form>
	<hr style="width: 100%; height: 2px;">
	<a href='member.do'>會員首頁</a>&nbsp;&nbsp;
	<a href='member.do?action=addUrl'>加入書籤</a>&nbsp;&nbsp;
	<a href='member.do?action=changePasswd'>改變密碼</a>&nbsp;&nbsp;
	<a href='member.do?action=logout'>登出</a>&nbsp;&nbsp;
	<hr style="width: 100%; height: 2px;">
</body>
</html>

