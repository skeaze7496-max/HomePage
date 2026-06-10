package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Response")
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//한글처리
			response.setContentType("text/html;charset=UTF-8");
			//문자 데이터를 출력하기 위한 스트림 객체생성
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<head><title></title></head>");
			out.print("<body>");
			out.print("ResponseServlet 요청 성공 .......");
			out.print("</body>");
			out.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
