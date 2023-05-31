package servlet;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/13Servlet/LifeCycle.do")
public class LifeCycle extends HttpServlet {

	@PostConstruct
	public void myPostConstruct() {
		System.out.println("myPostConstruct() 호출");

	}

	@Override
	public void init() throws ServletException { //실행후 처음 한번 실행
		System.out.println("init() 호출");
	}

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //service전체를 주석달면 doGet, doPost는 반드시 있어야
		System.out.println("service() 호출");
		super.service(req, resp); //이거 주석달면 doget, dopost 안넘어가. do들 호출이 안된다. doGet, doPost를 쓰든지, service를 쓰든지 둘중하나 보통. get이든 post든 무조건 실행돼야 하는거면 service
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet() 호출");
//		req.getRequestDispatcher("/13Servlet/LifeCycle.jsp").forward(req, resp); //jsp 호출이다. jsp 없이 할라면 이거 주석
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost() 호출");
//		req.getRequestDispatcher("/13Servlet/LifeCycle.jsp").forward(req, resp);
	}

	@Override
	public void destroy() {
		System.out.println("destroy() 호출");

	}

	@PreDestroy
	public void myPreDestroy() {
		System.out.println("myPreDestroy() 호출");
	}

}
