<%@ page language="java" contentType="text/html; charset=Big5" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head><title>Upload and Download files using Spring</title></head>
  <body>
    <table width="80%" border="1" cellspacing="0" cellpadding="5">
        <tr>
            <th width="4%">No</th>
            <th width="30%">�ɮצW��</th>
            <th width="30%">�Ƶ�</th>
            <th width="16%">����</th>
            <th width="20%">&nbsp;</th>
        </tr>
        <c:choose>
            <c:when test="${files != null}">
                <c:forEach var="file" items="${files}" varStatus="counter">
                    <tr>
                        <td>${counter.index + 1}</td>
                        <td>${file.filename}</td>
                        <td>${file.notes}</td>
                        <td>${file.type}</td>
                        <td>
                        	<div align="center">
                        		<a href="files_download.do?id=${file.id}">�U��</a> /
                            	<a href="files_delete.do?id=${file.id}">�R��</a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </c:when>
        </c:choose>
    </table>
 
    <h2>�W���ɮ�</h2>
    <form action="files_upload.do" method="post" enctype="multipart/form-data">
        <table width="60%" border="1" cellspacing="0">
            <tr>
                <td width="10%"><strong>���|</strong></td>
                <td width="90%"><input type="file" name="file" /></td>
            </tr>
            <tr>
                <td><strong>�Ƶ�</strong></td>
                <td><input type="text" name="notes" width="60" /></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type="submit" name="submit" value="�W��"/></td>
            </tr>
        </table>
    </form>
  </body>
</html>
 