<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head><title>내장 객체 - request</title></head>
<% request.setCharacterEncoding("UTF-8"); %>
<body>
<h2>1. 클라이언트와 서버의 환경정보 읽기</h2>
<ul>
<li>데이터 전송 방식 : <%=request.getMethod()  %></li>
<li>URL : <%=request.getRequestURL()  %></li>
<li>URI : <%=request.getRequestURI()  %></li>
<li>프로토콜 : <%=request.getProtocol()  %></li>
<li>서버명 : <%=request.getServerName()  %></li>
<li>서버 포트 : <%=request.getServerPort()  %></li>
<li>클라이언트 IP 주소 : <%=request.getRemoteAddr()  %></li>
<li>쿼리스트링 : <%=request.getQueryString()  %></li> <!-- POST 방식으로 하니 이걸 가려버린다. 비밀번호를 Get으로 넘기면 안되겠지 -->
<li>전송된 값 1 : <%=request.getParameter("eng")  %></li>
<li>전송된 값 2 : <%=request.getParameter("han")  %></li>
</ul>

</body>
</html>