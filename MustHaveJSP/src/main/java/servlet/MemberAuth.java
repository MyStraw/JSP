package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import membership.MemberDAO;
import membership.MemberDTO;
//
//@WebServlet(urlPatterns = "13Servlet/MemberAuth.mvc",
//initParams= {@WebInitParam(name="admin_id", value="nakja")})


public class MemberAuth extends HttpServlet {
	MemberDAO dao;
	
	@Override
	public void init() throws ServletException{
		
		ServletContext application = this.getServletContext();
		String driver = application.getInitParameter("MySQLDriver");
		String connectUrl = application.getInitParameter("MySQLURL");
		String oId = application.getInitParameter("MySQLId");
		String oPass = application.getInitParameter("MySQLPwd");
		
		dao = new MemberDAO(driver, connectUrl, oId, oPass);
	}
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		String admin_id = this.getInitParameter("admin_id");
		
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		
		MemberDTO memberDTO = dao.getMemberDTO(id,pass);
		
		String memberName = memberDTO.getName();
		if (memberName != null) {
			req.setAttribute("authMessage", memberName + " 회원님 방가방가^^*");
		}
		else {
			if(admin_id.equals(id))
				req.setAttribute("authMessage", admin_id + "는 최고 관리자입니다.");
			else
				req.setAttribute("authMessage", "귀하는 회원이 아닙니다.");
		}
		//req.getRequestDispatcher("/13Servlet/MemberAuth.jsp").forward(req, resp); //브라우저 위에 타이핑으로 호출이 된다.
		req.getRequestDispatcher("/WEB-INF/view/MemberAuthView.jsp").forward(req, resp); //브라우저에 이거 치면 호출이 안된다. 404 not found
		//web-inf 는 시스템 내부에서 사용하는 폴더. 외부에서 접근 불가. jsp는 외부에서 접근 못하도록 하는게 구현 방식이다 보통.
		//jsp 지금껏 하던거 맨날 ctrl f11 눌러서 바로 뷰랑 콘트롤러가 하나로 되어있어서 가능했다. 이제 mvc 따로따로 분리시켜서 할거다. view는 jsp로 가되, 외부에서 접근 못하도록
		//그래서 컨트롤러오만 접근 가능하게 만듦. 이런식으로 만들면 servlet을 통해서만 실행이 된다. servlet은 내부 로직으로 내부 web-inf로 접근 가능.
		//외부에선 jsp를 호출해서 쓰는지 안쓰는지 모른다. 지금은 이런 방식으로 많이 하고있다. 
	}
	
//	@Override
//	public void destroy() {
//		dao.close();
//	}
}
