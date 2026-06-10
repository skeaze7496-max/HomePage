<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.memberone.*" %>
<% request.setCharacterEncoding("utf-8"); %>

<%-- 폼 데이터를 VO에 자동으로 세팅 --%>
<jsp:useBean id="dao" class="com.memberone.StudentDAO"></jsp:useBean>
<jsp:useBean id="vo" class="com.memberone.StudentVO"></jsp:useBean>
<jsp:setProperty property="*" name="vo"/>

<%
    // 세션에서 아이디를 가져와 VO에 넣어줌 (DB 업데이트 시 필수)
    String loginID = (String)session.getAttribute("loginID");
    vo.setId(loginID); 
    
    // DAO의 void 메서드 호출
    dao.updateMember(vo);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="style.css" type="text/css" rel="stylesheet">
<title>정보수정확인</title>
</head>
<body>
    <script type="text/javascript">
        // void 타입이라 성공 여부를 알 수 없으므로, 
        // 메서드가 에러 없이 호출되었다는 전제하에 바로 완료 알림
        alert("회원 정보가 수정되었습니다.");
        location.href = "login.jsp";
    </script>
</body>
</html>