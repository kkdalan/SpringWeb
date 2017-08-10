<%@ page language="java" contentType="text/html; charset=Big5" pageEncoding="Big5"%>
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
	<form name="uploadForm" enctype="multipart/form-data" action="/SpringWeb/upload.do" method="POST">
		檔案名稱：<input name="name" type="text" /><br>
		選擇檔案：<input name="contents" type="file" /><br>
		<input type="submit" value="上傳" />
	</form>
</body>
</html>

