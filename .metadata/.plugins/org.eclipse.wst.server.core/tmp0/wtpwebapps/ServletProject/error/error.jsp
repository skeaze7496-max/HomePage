<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>

<% response.setStatus(HttpServletResponse.SC_OK); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예외 발생</title>
</head>
<body>
요청하신 처리과정에서 예외가 발생하였습니다.<br>
빠른 시일내에 문제를 해결하겠습니다.<br>
에러 타입 :<%=exception.getClass().getName() %><br>
에러 메시지 : <b><%=exception.getMessage() %><br>
</body>
</html>