<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String pageTitle = (String)request.getAttribute("PAGETITLE");
	String contentPage = request.getParameter("CONTENTPAGE");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=pageTitle %></title>
</head>
<body>
<table width="400" border="1" cellpaddnig="2" cellspacing="0">
	<!--top.jsp의 내용을 포함시킴-->
	<tr>
		<td colspan="2">
			<jsp:include page="/temp/module/top.jsp" flush="false"/>	
		</td>
	</tr>
	<!--template.jsp을 본문 내용 출력-->
	<tr>
		<td width="100" valign="top">
			<jsp:include page="/temp/module/left.jsp" flush="false"/>
		</td>
		<td width="300" valign="top">
			<%--내용 부분 시작--%>
			<jsp:include page="<%=contentPage%>" flush="false"/>
			<%--내용 부분 끝--%>
		</td>
	</tr>
	<!--bottom.jsp의 내용을 포함시킴-->
	<tr>
		<td colspan="2">
			<jsp:include page="/temp/module/bottom.jsp" flush="false"/>
		</td>
	</tr>

</table>
</body>
</html>