<%@ page language="java" contentType="text/html; charset=Big5"
	pageEncoding="Big5"%>
<%@ taglib prefix="ezpay" tagdir="/WEB-INF/tags"%>

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
		<table width='300' cellpadding='2' cellspacing='0' bgcolor='#cccccc'>
			<tr>
				<td>�s���ҡG</td>
				<td><input type='text' name='new_url' value='http://' size='30'
					maxlength='255'></td>
			</tr>
			<tr>
				<td colspan='2' align='center'></td>
				<td><input type='hidden' name='action' value="addUrl" /> <input
					type='submit' value="�s�W����" /></td>
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

