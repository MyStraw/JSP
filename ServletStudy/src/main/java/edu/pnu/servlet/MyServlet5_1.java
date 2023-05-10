package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myservlet5_1")

public class MyServlet5_1 extends HttpServlet { //읽어서 걍 보내는게 아파치, 읽어서 뭔갈 조작하고 write 하는게 톰캣.
												//white 가 out

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("MyServlet5_1");
		resp.setContentType("text/html; charset=utf-8"); 
		PrintWriter out = resp.getWriter();
		out.println("<table border=\"1\">");

       
        out.println("<tr>");
        for (int j = 2; j <= 9; j++) {
            out.println("<td>구구단 " + j + "단 </td>");
        }
        out.println("</tr>");

       
        for (int i = 1; i <= 9; i++) {
            out.println("<tr>");
            for (int j = 2; j <= 9; j++) {
                out.println("<td>"+j+" X " + i + " = " + j*i + "</td>");
            }
            out.println("</tr>");
        }

        out.println("</table>");

        out.close();
    }
}