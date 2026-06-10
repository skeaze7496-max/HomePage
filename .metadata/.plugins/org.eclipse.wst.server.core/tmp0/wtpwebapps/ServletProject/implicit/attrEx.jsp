<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--
	속성

	- PageContext, HttpServletRequest, HttpSession, ServletContext 객체 중 하나에 
	설정해 놓은 객체를 의미한다.

	- 속성은 이들 객체에 Map 인스턴스와 마찬가지로 이름/값의 쌍으로 저장되어 진다.
	- 각각의 객체에 저장된 속성들은 서로 다른 생존범위(Scope)를 가진다.
	
	속성과 스코프 
		구분	 		      접근			         생존범위			 사용
		--------------------------------------------------------------------------
		ServletContext   | 웹 어플리케이션내의 | WAS가 shutdown되기  | 전체 어플리케이션에서 공유되는 
					 	 | 모든 자원들		 | 전 까지는 유효함    | 자원(Connection Pool, JNDI, 이메일등)
		--------------------------------------------------------------------------
		HttpSession      | 특정 세션에 접근할  | HttpSession 객체의  | 클라이언트의 상태유지	
					     | 수 있는 서블릿이나  | 생존시까지 유효하다.| 정보나 장바구니
					     | JSP
		--------------------------------------------------------------------------
		HttpServletRquest | 어플리케이션에서   | 클라이언트 요청 객체가 | MVC패턴에서
						  | request에 접근     | 유지되는 동안 유효하다.| Model정보를 View에 전달
						  | 가능한 것들
		--------------------------------------------------------------------------
		Pagecontext       | 해당 JSP내에서만   | JSP 내에서만 유효      | JSP에서만 유효  
		
		
		속성과 파라미터의 차이점
							속성				파라미터		
		타입			ServletConctext			ServletConctext의 초기화 파라미터
						HttpSession				ServletConfig의 초기화 파라미터
						HttpServletRequest		HttpServletRequest의 파라미터
						PageContext
		--------------------------------------------------------------------------
		설정메소드 		setAttribute(String)  	초기파라미터 설정은 web.xml에서 설정
						name, Object(value)   	HttpServletRequest의 경우 was가 한다.
		--------------------------------------------------------------------------
		리턴탕비        Object					String 
		--------------------------------------------------------------------------
		창조메소드		getAttribute            getInitParameter(String name)
						(String name)			또는 getParameter(String)
			
						
		**
			request 속성과 requestDispatcher
				-MVC 웹 어플리케이션에서 Model에서 View쪽으로 데이터를 넘겨줄때,
				request scope 에 데이터를 저장해서 view측으로 전달해주게됨
						
					
-->
    <%
    //pageContext Scope에 속성 저장하기
    pageContext.setAttribute("pageAttribute", "홍");
    /* pageContext.setAttribute("pageAttribute", "홍",PageContext.PAGE_SCOPE); */
    
    
    // request Scope에 속성 저장하기
    request.setAttribute("requestAttribute", "010-1234-1234");
    /* pageContext.getAttribute("requestAttribute", "010-1234-1234",PageContext.REQUEST_SCOPE); */
    
    //session Scope에 속성저장하기
    session.setAttribute("sessionAttribute","xddd@naver.com");
    // pageContext.setAttribute("sessionAttribute","xddd@naver.com",pageContext.SESSION_SCOPE);
    
    //application Scope에 속성저장하기
    application.setAttribute("applicationAttribute", "Globalin(주)");
    // pageContext.setAttribute("applicationAttribute", "Globalin(주)",pageContext.APPLICATION_SCOPE);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<ul>
	<li>이름 : <%=pageContext.getAttribute("pageAttribute") %></li>
	<li>전번 : <%=request.getAttribute("requestAttribute") %></li>
	<li>메일 : <%=session.getAttribute("sessionAttribute") %></li>
	<li>회사 : <%=application.getAttribute("applicationAttribute") %></li>

</ul>
</body>
</html>