<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8");%>

<jsp:useBean id="member" class="com.actiontag.Member" scope="page"/>
<jsp:setProperty property="*" name="member"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
</head>
<body>
	<ul>
		<li>이름 : <jsp:getProperty property="name" name="member"/></li>
		<li>이메일 : <jsp:getProperty property="email" name="member"/></li>
		<li>전화번호 : <jsp:getProperty property="tel" name="member"/></li>
		
	</ul>
	
</body>
</html>