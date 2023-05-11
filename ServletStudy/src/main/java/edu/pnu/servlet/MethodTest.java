package edu.pnu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test") //이게 있어야 localhost:8080/ServletStudy/test 이게 가능
public class MethodTest extends HttpServlet {	
//post로 연결하는법. postman 다운받아서 설치후. 이거 이용하면 form 없이 뭐 된다는거 같은데. 일단 ㄱㄱ	
	private static final long serialVersionUID = 1L;
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("service");
		super.service(req, resp); //이건 지우면 밑에것들 다 안돼...야 하지만 부모클래스에서 얘를 자동으로 호출한다.
		//여기서 얘는 Get인지 Post 인지 이런것만 구분
		//얘 없어도 밑에 doGet doPost 등 된다. 
		//super 없애면 service만 계속됨
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doDelete");
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPut");
	}

}
