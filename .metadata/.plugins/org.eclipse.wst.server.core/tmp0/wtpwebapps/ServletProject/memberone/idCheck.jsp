<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="com.memberone.StudentDAO"/>

<%
	//request.setCharacterEncoding("UTF-8"); // 한글 입력 대비
	String id = request.getParameter("id");
	boolean check  = dao.idCheck(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 체크</title>
<link href="style.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="script.js"></script>
</head>
<body bgcolor="#ffffcc">
<br>
	<div align="center">
		<b><%=id %></b>
    
<% 		if(check) { 
        	out.println("는 이미 존재하는 ID입니다.");
   	 	 } else { 
			out.println("는 사용가능한 ID입니다..");
    	 } 
%>
<a href="#" onclick="javascript:self.close()">닫기</a>
    	 
    </div>
</body>
</html>