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
	<img src='images/spring.jpg' alt='Spring 線上書籤  Logo' border='0'
		align='left' valign='botton' />
	<h1>&nbsp;Spring 線上書籤</h1>
	<hr style="width: 100%; height: 2px;">
	<hr style="width: 100%; height: 2px;">
	<spring:bind path='command.*'>
		<font color="red"> <b>${status.errorMessage}</b>
		</font>
	</spring:bind>
	<form method='post' action='register.do'>
		<table bgcolor=#cccccc>
			<tr>
				<td>郵件地址：</td>
				<td><spring:bind path='command.email'>
						<input type='text' name='${status.expression}'
							value='${status.value}' size='30' maxlength='100'>
					</spring:bind></td>
			</tr>
			<tr>
				<td>使用者名稱(最大16字元)：</td>
				<td valign='top'><spring:bind path='command.username'>
						<input type='text' name='${status.expression}'
							value='${status.value}' size='16' maxlength='16'>
					</spring:bind></td>
			</tr>
			<tr>
				<td>密碼(6到16字元)：</td>
				<td valign='top'><spring:bind path='command.passwd'>
						<input type='text' name='${status.expression}'
							value='${status.value}' size='16' maxlength='16'>
					</spring:bind></td>
			</tr>
			<tr>
				<td>確認密碼：</td>
				<td valign='top'><spring:bind path='command.passwd2'>
						<input type='text' name='${status.expression}'
							value='${status.value}' size='16' maxlength='16'>
					</spring:bind></td>
			</tr>
			<tr>
				<td colspan='2' align='center'><input type='submit' value='註冊'>
				</td>
			</tr>

		</table>
	</form>
</body>
</html>
