	package com.bbs;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/VisitInsert")
public class VisitInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProcess(request, response);
	}
	
	protected void requestProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		//클라이언트가 요청한 파라미터를 가지고 옴
		String writer = request.getParameter("writer");
		String memo = request.getParameter("memo");
		System.out.println("작성자 : "+writer);
		System.out.println("내용 : "+memo);
		//폼에서 가져온 파라미터를 데이터 베이스에 저장한다.
		String sql = "insert into visit(no, writer, memo, regdate) "
					+"values(visit_seq.nextval, ?, ?, sysdate)";
			
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", 
					"scott", 
					"tiger");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, memo);
			
			pstmt.executeUpdate(); //실행메소드
			
			
		} catch (ClassNotFoundException ce) {
			
		} catch (SQLException se) {
			 
		} finally {
			try {
				if(pstmt != null)pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
				
			} try {
				if(con != null)pstmt.close();
				
			} catch(SQLException se) {
				se.printStackTrace();
			}
		}
		response.sendRedirect("VisitList");

	}
	
}
