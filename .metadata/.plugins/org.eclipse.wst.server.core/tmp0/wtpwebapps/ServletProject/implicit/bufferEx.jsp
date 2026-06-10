<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	int bufferSize = out.getBufferSize();
    	int remainSize = out.getRemaining();
    	int userSize = bufferSize - remainSize; 
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
버퍼 전체의 크기 : <%=bufferSize %><br>
사용한 버퍼의 크기 : <%=userSize %><br>
남은 버퍼크기 : <%out.print(remainSize); %>byte<br> 


</body>
</html>