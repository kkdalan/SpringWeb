<%@ page language="java" contentType="text/html; charset=Big5"
	pageEncoding="Big5"%>

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
	<img src='images/spring.jpg' alt='Spring �u�W����  Logo' border='0' align='left' valign='botton' />
	<h1>&nbsp;Spring �u�W����</h1>
	<hr style="width: 100%; height: 2px;">
	<hr style="width: 100%; height: 2px;">
	<br>
	<form method='post' action='member.do'>
		<table width='300' cellpadding='2' cellspacing='0' bgcolor='#cccccc'>
			<tr>
				<td>�s�K�X�G</td>
				<td><input type='password' name='new_passwd' size='16'
					maxlength='16'> <input type='hidden' name='action'
					value='changePasswd'></td>
			</tr>
			<tr>
				<td colspan='2' align='center'></td>
				<td><input type='submit' value="���ܱK�X" /></td>
			</tr>
		</table>
		<br>
	</form>
	<hr style="width: 100%; height: 2px;">
     <a href='member.do'>�|������</a>&nbsp;&nbsp;
     <a href='member.do?action=addUrl'>�[�J����</a>&nbsp;&nbsp;
     <a href='member.do?action=changePasswd'>���ܱK�X</a>&nbsp;&nbsp;
     <a href='member.do?action=logout'>�n�X</a>&nbsp;&nbsp;
     <hr style="width: 100%; height: 2px;">
</body>
</html>

