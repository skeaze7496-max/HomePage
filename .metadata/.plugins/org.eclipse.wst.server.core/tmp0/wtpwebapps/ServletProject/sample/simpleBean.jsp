<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
		request.setCharacterEncoding("utf-8"); // 인코딩 
		//String message = request.getParameter("message");
%>
<!-- SimpleData msg = new SimpleData(); -->
<jsp:useBean id="msg" class="com.sample.SimpleData" scope="page"></jsp:useBean>
<!-- msg.setMessage(message); -->
<jsp:setProperty property="message" name="msg"/>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h1>자바빈즈 결과</h1>
<%-- <%=message %> --%>
<hr color="red">
<font size="7">
메세지 :  <jsp:getProperty property="message" name="msg"/>
</font>
</body>
</html>