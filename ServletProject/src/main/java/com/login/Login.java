package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.PortableServer.RequestProcessingPolicy;


//@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProcess(request, response);
	}

	protected void requestProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		try {
			HttpSession session = request.getSession(false);
			
			if(session != null) { //세션에 값이 없지않을경우 / 로그인 성공시
				String sessionId = session.getId();
				System.out.println("아이디 : "+sessionId);
				
				String user = (String)session.getAttribute("user");
				
				out.print("<html>");
				out.print("<body>");
				
				out.print("<table width=300 border=1>");
				out.print("<tr>");
				out.print("<td width=300 align=center>"+user+"님의 로그인"+"</td>");				
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td align=center>");
				out.print("<a href=#>회원정보</a>");
				out.print("<a href=Logout>&nbsp;로그아웃</a>");
				
				out.print("</td>");
				out.print("</tr>");
				out.print("</table>");
								
				out.print("</body>");
				out.print("</html>");
				
			}else {//로그인 실패시
				out.print("<html>");
				out.print("<body>");
				out.print("<form action=LoginCheck method=post>");
				out.print("<table width=300 border=1>");
				out.print("<tr>");
				out.print("<th width=100>아이디</th>");
				out.print("<td width=200>&nbsp;<input type=text name=id></td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<th width=100>비밀번호</th>");
				out.print("<td width=200>&nbsp;<input type=password name=pw></td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td colspan=2 align=center>");
				out.print("<input type=button value=회원가입>");
				out.print("<input type=submit value=로그인>");				
				
				out.print("</td>");
				out.print("</tr>");
				out.print("</table>");
				
				out.print("</form>");
				out.print("</body>");
				out.print("</html>");
			}
			
			
			
		} finally {
			out.close();
		}	
		
	}
}
