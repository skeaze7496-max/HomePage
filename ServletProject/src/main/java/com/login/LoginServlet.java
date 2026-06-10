package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProcess(request, response);
	}
	
	protected void requestProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String id = request.getParameter("userid");
			String pw = request.getParameter("password");
			
			System.out.println("아이디 : "+id);
			System.out.println("비밀번호 : "+pw);
			
			//한글처리
			response.setContentType("text/html;charset=UTF-8");
			//문자 데이터를 출력하기 위한 스트림 객체생성
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<head><title></title></head>");
			out.print("<body>");
			out.print("아이디 : "+id+"<br>");
			out.print("비밀번호 : "+pw+"<br>");
			out.print("</body>");
			out.print("</html>");
	}
}
