<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.*" %>
<%
	//쿠키생성
	Cookie cookie = new Cookie("hour", "1time");
	//쿠키의 유효시간 설정
	cookie.setMaxAge(60);
	response.addCookie(cookie);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
유효시간이 60초인 hour 쿠키 생성
</body>
</html>