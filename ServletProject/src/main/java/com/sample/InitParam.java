package com.sample;

/* ServletConfig와 ServletContext 객체의 파라미터 값을 web.xml에 저장해 놓는다 
 * [개념 정리 요약]
 * ServletConfig API 를 활용한 초기화 파라미터 (특정 서블릿 전용방)
 *  - 톰캣이 해당 서블릿을 생성할 때 딱 1개만 만들어주는 전용 객체.
 *  - @WebServlet의 initParams에 지정된 값을 저장하며, 다른 서블릿은 이 값을 볼 수 없음.
 *  - getServletConfig().getInitParameter("이름") 형태로 값을 꺼냄.
 * 
 * ServletContext API 를 활용한 초기화 파라미터 (웹 애플리케이션 전체 공용방)
 *  - 전체 프로젝트(웹 앱)당 딱 1개만 생성되는 거대한 공용 저장소.
 *  - 모든 서블릿, JSP가 이 공간을 공유하여 데이터를 주고받거나 함께 쓸 수 있음.
 *  - 자바 코드에서 꺼낼 때는 getServletContext().getAttribute("이름") 형태로 꺼냄.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet: 이 클래스가 서블릿임을 톰캣에게 알리고, URL 연결 및 전용 초기화 파라미터를 설정함
@WebServlet(name="InitParam", urlPatterns = {"/InitParam"}, 
		initParams = {  
						// [ServletConfig 영역] 이 서블릿만 단독으로 사용할 고정 값을 지정함
						@WebInitParam(name="tel", value="010-1111-2222"),
						@WebInitParam(name="email", value="globalin@naver.com")
						})
public class InitParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 서블릿 내부에서 사용할 멤버 변수 선언
	private String company;
	private String manager;
	private String tel;
	private String email;
		
	// init(): 톰캣 서버가 켜진 후 이 서블릿이 '최초로 호출될 때 딱 한 번' 실행되는 초기화 메서드
	@Override
	public void init() throws ServletException {
		System.out.println("초기화 메소드 수행.............");
		
		// 1. ServletConfig(서블릿 전용방)에 저장되어 있던 고정 설정을 꺼내와 변수에 보관함
		tel = getServletConfig().getInitParameter("tel");
		email = getServletConfig().getInitParameter("email");	
		
		// 2. 임의의 텍스트 데이터를 임시 변수에 대입함
		company = "Globalin";
		manager = "JungSub Kim";
		
		// 3. [중요] 모든 서블릿이 공유하는 거대한 공용 창고(ServletContext)에 setAttribute()로 데이터를 저장함
		// 이제 이 프로젝트 내의 다른 서블릿들도 "company"와 "manager"라는 열쇠(Key)로 이 값들을 꺼내 쓸 수 있게 됨
		getServletContext().setAttribute("company", company);
		getServletContext().setAttribute("manager", manager);
	}
	
	// doGet(): 클라이언트가 브라우저 주소창에 URL을 입력하는 등 GET 방식으로 요청을 보냈을 때 실행됨
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProcess(request, response); // 실제 처리 로직인 requestProcess 메서드로 일감을 넘김
	}

	// doPost(): 클라이언트가 <form> 태그 등을 통해 데이터를 숨겨서 POST 방식으로 요청을 보냈을 때 실행됨
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProcess(request, response); // 마찬가지로 requestProcess 메서드로 일감을 넘김
	}
	
	// requestProcess(): GET이든 POST든 상관없이 들어오는 모든 실제 요청을 처리하고 응답을 만들어내는 핵심 메서드
	protected void requestProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// [요청 한글 처리] 클라이언트(브라우저)가 보낸 데이터가 한글일 때 글자가 깨지지 않도록 인코딩 형식을 지정함
		request.setCharacterEncoding("utf-8"); 
		
		// [공용 창고 데이터 추출] 사용자가 요청할 때마다 공용 창고(ServletContext)를 열어 
		// 아까 init() 메서드 수행 시 집어넣었던 "company"와 "manager" 값을 가로채어 가져옴
		// 창고에 넣을 때 오브젝트(Object) 타입으로 변형되어 들어갔기 때문에 꺼낼 때는 원래 타입인 (String)으로 형변환(Casting)이 필수임!
		String com = (String) getServletContext().getAttribute("company");
		String man = (String) getServletContext().getAttribute("manager");
		
		// [응답 한글 처리] 서버가 브라우저에게 "지금 보낼 데이터는 UTF-8 인코딩이 적용된 HTML 문서야"라고 선언하는 부분
		response.setContentType("text/html;charset=utf-8"); 
		
		// [출력 스트림 획득] 브라우저 화면에 텍스트나 HTML 코드를 직접 그려주기 위한 통로(스트림)를 엶
		PrintWriter out = response.getWriter(); 
		
		// [HTML 브라우저 화면 출력] out.print()를 이용하여 브라우저가 해석할 HTML 본문을 전달함
		out.print("<html><body>"); 
		
		// 클라이언트가 파라미터로 보낸 name값들의 묶음을 가져오는 코드 (여기서는 화면 출력에 직접 쓰이진 않음)
		Enumeration<String> enu = request.getParameterNames(); 
		
		// 아까 공용창고(ServletContext)에서 꺼낸 com, man 변수값과 
		// 전용창고(ServletConfig)에서 꺼내뒀던 tel, email 변수값을 화면에 뿌려줌
		out.print("회사명 : " + com + "<br>");
		out.print("매니저 : " + man + "<br>");
		out.print("전화번호 : " + tel + "<br>");
		out.print("email : " + email + "<br>");
		
		out.print("</html></body>");
	}
}