<%@ page language="java" contentType="text/html; charset=Big5" pageEncoding="Big5"%>
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
	<form name="uploadForm" enctype="multipart/form-data" action="/SpringWeb/upload.do" method="POST">
		�ɮצW�١G<input name="name" type="text" /><br>
		����ɮסG<input name="contents" type="file" /><br>
		<input type="submit" value="�W��" />
	</form>
</body>
</html>

