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
	<img src='images/spring.jpg' alt='Spring �u�W����  Logo' border='0'
		align='left' valign='botton' />
	<h1>&nbsp;Spring �u�W����</h1>
	<hr style="width: 100%; height: 2px;">
	<hr style="width: 100%; height: 2px;">
	<spring:bind path='command.*'>
		<font color="red"> <b>${status.errorMessage}</b>
		</font>
	</spring:bind>
	<form method='post' action='register.do'>
		<table bgcolor=#cccccc>
			<tr>
				<td>�l��a�}�G</td>
				<td><spring:bind path='command.email'>
						<input type='text' name='${status.expression}'
							value='${status.value}' size='30' maxlength='100'>
					</spring:bind></td>
			</tr>
			<tr>
				<td>�ϥΪ̦W��(�̤j16�r��)�G</td>
				<td valign='top'><spring:bind path='command.username'>
						<input type='text' name='${status.expression}'
							value='${status.value}' size='16' maxlength='16'>
					</spring:bind></td>
			</tr>
			<tr>
				<td>�K�X(6��16�r��)�G</td>
				<td valign='top'><spring:bind path='command.passwd'>
						<input type='text' name='${status.expression}'
							value='${status.value}' size='16' maxlength='16'>
					</spring:bind></td>
			</tr>
			<tr>
				<td>�T�{�K�X�G</td>
				<td valign='top'><spring:bind path='command.passwd2'>
						<input type='text' name='${status.expression}'
							value='${status.value}' size='16' maxlength='16'>
					</spring:bind></td>
			</tr>
			<tr>
				<td colspan='2' align='center'><input type='submit' value='���U'>
				</td>
			</tr>

		</table>
	</form>
</body>
</html>
