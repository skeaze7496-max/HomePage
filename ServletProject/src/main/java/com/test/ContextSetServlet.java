package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ContextSet")
public class ContextSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//속성 값 저장
			String company = "globalin";
			String manager = "JungSub Kim";
			
			getServletContext().setAttribute("company", company);
			getServletContext().setAttribute("manager", manager);
			
			String com = (String) getServletContext().getAttribute("company");
			String man = (String) getServletContext().getAttribute("manager");
			
			//요청시 한글처리
			request.setCharacterEncoding("utf-8"); // 클라이언트가 보낸 한글 데이터가 깨지지 않도록 인코딩을 설정합니다.
			
			//응답시 한글처리
			response.setContentType("text/html;charset=utf-8"); // 브라우저에게 HTML 형식의 UTF-8 인코딩 데이터로 응답하겠다고 선언합니다.
			PrintWriter out = response.getWriter(); // 브라우저에 텍스트(HTML)를 출력하기 위한 스트림 객체를 얻어옵니다.
			out.print("<html><body>"); // HTML 문서의 시작 태그를 브라우저에 보냅니다.
			Enumeration<String> enu = request.getParameterNames(); // 클라이언트가 보낸 모든 parameter(입력 필드)의 name 속성들을 배열 형태(Enumeration)로 가져옵니다.
			
			out.print("회 사 : "+com+"<br>");
			out.print("관리자 : "+man+"<br>");
			
			out.print("</html></body>");

		}
			 

	}

