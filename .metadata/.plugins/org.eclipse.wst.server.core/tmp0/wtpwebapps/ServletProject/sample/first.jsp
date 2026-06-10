<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP File</title>
</head>
<body>
	<h2>JSP Script</h2>
	<%
	//스크립트 연산 처리 
		String scriptlet = "스크립트릿";
		String comment = "주먹문";
	// 출력
	out.print("내장 객체를 이용한 출력 : "+declation+"<br>");
	%>
	
	
	선언문 출력하기 (변수) : <%=declation %> <br>
	선언문 출력하기 (메소드) : <%=declationMethod() %> <br>
	스크릿트릿 출력하기 : <%=scriptlet %> <br>
	<!--JSP에서 사용하는 HTML주석  -->
	<!--HTML 주석 : <%=comment%>  --><br><br>
	<%--JSP 주석 : <%=comment%> --%>
	
	<%
	//자바 주석 
	
	/*
		자바 주석
	*/
	
	%>
	
	<%! 
		//변수 선언
		String declation = "선언문";
		
		public String declationMethod() {
			return declation;
			
		}
		
	%>
	
	
</body>
</html>