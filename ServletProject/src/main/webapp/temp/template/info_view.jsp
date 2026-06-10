<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<table width="100%" border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td>제품 번호</td><td>xxxx</td>
	</tr>
	<tr>
		<td>가 격</td><td>10,000</td>
	</tr>
</table>
<jsp:include page="info_sub.jsp" flush="false">
		<jsp:param value="A" name="type"/>
</jsp:include>
</body>
</html>