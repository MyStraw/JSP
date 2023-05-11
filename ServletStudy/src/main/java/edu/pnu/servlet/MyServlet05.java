package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myservlet05")

public class MyServlet05 extends HttpServlet { //읽어서 걍 보내는게 아파치, 읽어서 뭔갈 조작하고 write 하는게 톰캣.
												//white 가 out

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("MyServlet05");
		resp.setContentType("text/html; charset=utf-8"); 
		PrintWriter out = resp.getWriter();
		out.println("<table border=\"1\">"); 
		out.println("<tr>");	
		out.println("<td>번호</td><td>나라</td><td>수도</td><td>인구</td>");  
		out.println("</tr>");		
		out.println("<tr>");	
		out.println("<td>1</td><td>대한민국</td><td>서울</td><td>1000만</td>");
		out.println("</tr>");		
		out.println("<tr>");	
		out.println("<td>2</td><td>미국</td><td>워싱턴</td><td>70만</td>");
		out.println("</tr>");		
		out.println("<tr>");	
		out.println("<td>3</td><td>일본</td><td>도쿄</td><td>1400만</td>");
		out.println("</tr>");		
		out.println("<tr>");	
		out.println("<td>4</td><td>중국</td><td>베이징</td><td>2100만</td>");
		out.println("</tr>");		
		out.println("</table>");	
		
		String[][] border = {{"번호", "나라", "수도", "인구"}, {"1", "대한민국", "서울", "1000만"}};
		
		out.close();
	}
}