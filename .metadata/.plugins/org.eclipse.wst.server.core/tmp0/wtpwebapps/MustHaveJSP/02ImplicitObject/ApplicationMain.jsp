<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head><title>내장 객체</title></head>
<body>
<h2>web.xml에 설정한 내용 읽어오기</h2>
초기화 매개변수 : <%= application.getInitParameter("INIT_PARAM") %> <!-- 톰캣 처음 구동될때 딱 1개 만들어진다. 초기화된 정보 갖고오기 좋다 -->

<h2>서버의 물리적 경로 얻어오기</h2>
application 내장 객체 : <%= application.getRealPath("/02ImplicitObject") %>

<h2>선언부에서 application 내장 객체 사용하기</h2>
<%!
public String useImplicitObject() {
return this.getServletContext().getRealPath("/02ImplicitObject");
}
public String useImplicitObject(ServletContext app) {
return app.getRealPath("02ImplicitObject"); //자바로 컨버전 되면서 클래스 제일 위에 이 선언부들이 올라간다.
}
%>
<ul>
<li>this 사용 :  <%= useImplicitObject() %></li> <!-- 이 this 는 서블릿의 this다. 아래꺼랑 같네 결과가. 어플리케이션 객체 -->
<li>내장 객체를 인수로 전달 :  <%= useImplicitObject(application) %></li>
</ul>
</body>
</html>