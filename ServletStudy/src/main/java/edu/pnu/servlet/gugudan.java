package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gugudan")

public class gugudan extends HttpServlet { // 읽어서 걍 보내는게 아파치, 읽어서 뭔갈 조작하고 write 하는게 톰캣.
												// white 가 out

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get은 html에서 넘겨줄때 , post 방식으로 넘겨줄건지. 이건 get. 정보 안숨기고 넘기는거.
		// post 방식으로 요청하면 이걸로 안돼. form으로 해야된다.
		// 파라미터 뒤에 모든 정보들이 HttpServletRequest 이걸로 넘어온다.
		// Localhost:8080/ServletStudy/gugudan&num=4 &num=4 이부분이 파라미터. 요청하는 정보.
		// 이 정보를 읽어오는게 getParameter이고. "num" 이름으로 읽어온다. 무조건 스트링 타입으로.
		// 파라미터 정보가 아무것도 없으면 = null
		System.out.println("gugudan");
		resp.setContentType("text/html; charset=utf-8");
		String type = req.getParameter("type");
		String snum = req.getParameter("num");
		int num = 2; // 없으면 2단.

		if (snum != null)				num = Integer.parseInt(snum);
		if (type == null || type == "")	type = "list";

		try (PrintWriter out = resp.getWriter();) {
			if (type.equals("table"))	table(num, out);
			else						list(num, out);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void table(int num, PrintWriter out) {
		out.println("<table border=\"1\">");
		out.println("<tr>");
		out.println("<td>구구단 " + num + "단 </td>");
		out.println("</tr>");
		for (int j = 2; j <= 9; j++) {
			out.println("<tr>");
			out.println("<td>" + num + " X " + num + " = " + j * num + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");
	}

	private void list(int num, PrintWriter out) {
		out.println("<h2>구구단 타입 3 (Servlet)</h2>");
		out.println("<h2>구구단 " + num + "단</h2>");
		out.println("<ul>");
		for (int i = 1; i <= 9; i++) {
			out.println("<li>" + num + " X " + i + " = " + num * i + "</li>");
		}
		out.println("</ul>");
	}
}