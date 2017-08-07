<%@ page language="java" contentType="text/html; charset=Big5"
	pageEncoding="Big5"%>
<%@ taglib prefix="ezpay" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Spring �u�W����</title>
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
	<img src='images/spring.jpg' alt='Spring �u�W����  Logo' border='0'
		align='left' valign='botton' />
	<h1>&nbsp;Spring �u�W����</h1>
	<hr style="width: 100%; height: 2px;">
	<hr style="width: 100%; height: 2px;">
	<br>${valid_user}�z�n�G<br>
	<br>
	<form name="bm_table" method='post' action='member.do'>
		<table width='300' cellpadding='2' cellspacing='0'>
			<tr bgcolor='#cccccc'>
				<td><strong>����</strong></td>
				<td><strong>�R��?</strong></td>
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
					type='submit' value="�R��" /></td>
			</tr>
		</table>
	</form>
	<hr style="width: 100%; height: 2px;">
	<a href='member.do'>�|������</a>&nbsp;&nbsp;
	<a href='member.do?action=addUrl'>�[�J����</a>&nbsp;&nbsp;
	<a href='member.do?action=changePasswd'>���ܱK�X</a>&nbsp;&nbsp;
	<a href='member.do?action=logout'>�n�X</a>&nbsp;&nbsp;
	<hr style="width: 100%; height: 2px;">
</body>
</html>

