package com.member; // 이 서블릿 클래스가 속한 패키지(폴더 경로)를 지정합니다.

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member/Member") // 브라우저에서 어떤 URL(/member/Member)로 접근했을 때 이 서블릿을 실행할지 주소를 매핑합니다.
public class MemberServlet extends HttpServlet { // HTTP 요청을 처리하기 위해 HttpServlet 클래스를 상속받습니다.
	private static final long serialVersionUID = 1L; // 직렬화(Serialization) 버전 관리를 위한 고유 식별자입니다.

	/**
	 * 1. doGet 메서드
	 * - 역할: 클라이언트가 'GET' 방식으로 요청을 보냈을 때 서블릿 컨테이너(톰캣)에 의해 호출됩니다.
	 * - 주로 주소창 입력, 링크 클릭, 혹은 <form method="get"> 요청을 처리합니다.
	 * - 여기서는 직접 처리하지 않고 공통 처리 메서드인 requestProcess로 요청을 넘깁니다.
	 * POST랑 대비됨
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProcess(request, response); // 공통 처리 메서드인 requestProcess를 호출합니다.
	}

	/**
	 * 2. doPost 메서드
	 * - 역할: 클라이언트가 'POST' 방식으로 요청을 보냈을 때 서블릿 컨테이너(톰캣)에 의해 호출됩니다.
	 * - 주로 회원가입, 로그인, 글쓰기 등 <form method="post">를 통해 데이터를 숨겨서 보낼 때 처리합니다.
	 * - doGet과 마찬가지로 공통 처리 메서드인 requestProcess로 요청을 넘깁니다.
	 * Get이랑 대비됨.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProcess(request, response); // 공통 처리 메서드인 requestProcess를 호출합니다.
	}

	
	/**
	 * 3. requestProcess 메서드 (사용자 정의 메서드)
	 * - 역할: GET 요청과 POST 요청의 처리 로직이 동일할 때, 코드 중복을 피하기 위해 만든 공통 처리 메서드입니다.
	 * - 클라이언트가 보낸 데이터를 읽어오고(입력), 처리한 뒤, HTML 결과 화면을 만들어 브라우저에 돌려주는(출력) 핵심 로직을 수행합니다.
	 */
	protected void requestProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청시 한글처리
		request.setCharacterEncoding("utf-8"); // 클라이언트가 보낸 한글 데이터가 깨지지 않도록 인코딩을 설정합니다.
		
		//응답시 한글처리
		response.setContentType("text/html;charset=utf-8"); // 브라우저에게 HTML 형식의 UTF-8 인코딩 데이터로 응답하겠다고 선언합니다.
		PrintWriter out = response.getWriter(); // 브라우저에 텍스트(HTML)를 출력하기 위한 스트림 객체를 얻어옵니다.
		out.print("<html><body>"); // HTML 문서의 시작 태그를 브라우저에 보냅니다.
		Enumeration<String> enu = request.getParameterNames(); // 클라이언트가 보낸 모든 parameter(입력 필드)의 name 속성들을 배열 형태(Enumeration)로 가져옵니다.
		
		
		
		// 폼(Form) 등에서 넘어온 parameter가 더 없을 때까지 반복문을 돌립니다.
		while (enu.hasMoreElements()) {
			String name = enu.nextElement(); // 다음 parameter의 name(이름)을 꺼내옵니다.
			String value = request.getParameter(name); // 꺼내온 name을 이용해 실제 사용자가 입력한 값(value)을 가져옵니다.
			out.print(name+" : "+value+"<br>");

		}
		out.print("</body></html>"); // HTML 문서의 끝 태그를 브라우저에 보냅니다. (현재 위치상 아래 while문 결과가 body 태그 밖에 찍히게 됩니다.)
		
	}
}