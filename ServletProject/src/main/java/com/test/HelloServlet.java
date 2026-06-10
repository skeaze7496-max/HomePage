package com.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 브라우저에서 /HelloServlet 으로 요청할 수 있도록 URL 매핑을 추가합니다.
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    // 1. 서블릿이 처음 생성될 때 딱 한 번 호출되는 메서드
    @Override
    public void init() throws ServletException {
        System.out.println("init 요청 .......");
    }

    // 2. 클라이언트가 GET 방식으로 요청할 때마다 호출되는 메서드
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 콘솔에 출력
        System.out.println("HelloServlet 요청....");
        
        // (선택 사항) 브라우저 화면에 글자를 띄우고 싶다면 아래 주석을 해제하세요.
        // response.setContentType("text/html; charset=UTF-8");
        // response.getWriter().append("HelloServlet 요청 성공!");
    }

    // 3. 서버가 중지되거나 서블릿이 소멸될 때 호출되는 메서드
    @Override
    public void destroy() {
        System.out.println("destroy 요청");
    }
}