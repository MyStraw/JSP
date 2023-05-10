package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myservlet04")

public class MyServlet04 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("MyServlet04");
		resp.setContentType("text/html; charset=utf-8"); //리스폰스.객체 호출. 02처럼 plain으로 하면 <h2>이런 글자까지 그냥 다 나오는거고. html이면 html 형식으로 h1으로 글자 크게 해줌 
		PrintWriter out = resp.getWriter();
		out.println("<table border=\"1\">"); //그냥 html 에서는 <table border="1"> 이거하면 되는데 여기 print로 오는순간 "이거를 인식을 해버린다
											//"<table border=" 여기까지를 글자로 인식하게 된다. 그걸 구분해주는게 앞에 \ 하나 붙이면 글자로 인식하지 말라고 하는거.
		out.println("<tr>");	
		out.println("<td>번호</td><td>나라</td><td>수도</td>");
		out.println("</tr>");		
		out.println("<tr>");
		out.println("<td>1</td><td>대한민국</td><td>서울</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>2</td><td>미국</td><td>워싱턴</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>3</td><td>일본</td><td>도쿄</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>4</td><td>중국</td><td>베이징</td>");
		out.println("</tr>");
		out.println("</table>");	
		
		
		out.close();
	}
}