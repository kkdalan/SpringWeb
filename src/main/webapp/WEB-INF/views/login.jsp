<%@ page language="java" contentType="text/html; charset=Big5"
	pageEncoding="Big5"%>
<%@ taglib prefix="ezpay" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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
	<img src='/resources/images/spring.jpg' alt='Spring �u�W����  Logo' border='0' align='left'  />
	<h1>&nbsp;Spring �u�W����</h1>
	<hr style="width: 100%; height: 2px;">
	<hr style="width: 100%; height: 2px;">
	<ul>
		<li>�u�W�x�s�z������ &nbsp;&nbsp;
		<li>���ɱz�ڪ����� &nbsp;&nbsp;
		<li>�֨Өq�X�̻Ū��쵲
	</ul>
	<a href='register.do'>�٤��O�|��?</a>
	<p>
	<form method='post' action='login.do'>
		<spring:bind path='command.*'>
			<font color="red"> <b>${status.errorMessage}</b></font>
			<br>
		</spring:bind>
		<table bgcolor=#cccccc>
			<tr>
				<td colspan='2'>�|���n�J</td>
			</tr>
			<tr>
				<td>�W�١G</td>
				<td><spring:bind path='command.username'>
						<input type='text' name='${status.expression}'
							value='${status.value}'>
					</spring:bind></td>
			</tr>
			<tr>
				<td>�K�X�G</td>
				<td><spring:bind path='command.passwd'>
						<input type='password' name='${status.expression}'
							value='${status.value}'>
					</spring:bind></td>
			</tr>
			<tr>
				<td colspan='2' align='center'><input type='submit' value='�n�J'>
				</td>
			</tr>
			<tr>
				<td colspan='2'><a href='forgot.do'>�ѰO�K�X?</a></td>
			</tr>
		</table>
	</form>
	<a href='/SpringWeb/files_show.do'>�ɮ׺޲z����</a>
</body>
</html>

