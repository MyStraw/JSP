package edu.pnu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet01 extends HttpServlet { //이거에 상속받은 애들만 찾게. HttpServlet로부터 상속받은애. 메인이 없어도 실행. 톰캣이 이 서비스라 불리는 애를 호출해주기 때문
	// 1. Default Serial Version ID 추가 우클릭에 add 해서 노란줄 없애

	private static final long serialVersionUID = 1L;

	@Override //Ctrl + space + service 까지 치고 엔터~
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("MyServlet01"); //이건 콘솔에다가만 찍는거야. 서블릿을 못찾겠다 하는거면 여기 이 클래스가 문제
	}
}

// url 등록해야~