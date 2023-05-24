<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//pageContext.setAttribute("scopeValue", "페이지 영역");
request.setAttribute("scopeValue", "리퀘스트 영역");
session.setAttribute("scopeValue", "세션 영역");
application.setAttribute("scopeValue", "애플리케이션 영역"); //각각 데이터 다 집어넣음. scopeValue 변수는 동일하고 값만 다르게
%>
<html>
<head>
<meta charset="UTF-8">
<title>표현 언어(EL) - 내장 객체</title>
</head>
<body>
	<h2>ImplicitObjMain 페이지</h2>
	<h3>각 영역에 저장된 속성 읽기</h3>
	<ul>
		<li>페이지 영역 : ${pageScope.scopeValue}</li> <!-- 이 방식으로도 쓴다. 밑에 똑같은거 2개. 얘는 공백 -->
		<%
		String scopeValue = (String)pageContext.getAttribute("scopeValue"); //얘는 null이 된다
		%>
		<li>페이지 영역 : <%= scopeValue %></li>
		<li>페이지 영역 : <%= pageContext.getAttribute("scopeValue") %></li>		
		<li>리퀘스트 영역 : ${requestScope.scopeValue}</li>
		<li>세션 영역 : ${sessionScope.scopeValue}</li>
		<li>애플리케이션 영역 : ${applicationScope.scopeValue}</li>
	</ul>

	<h3>영역 지정 없이 속성 읽기</h3>
	<ul>
		<li>${scopeValue}</li> <!-- 제일 좁은 영역의것 부터 먼저 찾아온다. 페이지꺼부터. 없으면 request꺼로.-->
	</ul>

<%-- <jsp:forward page="ImplicitForwardResult.jsp" /> --%>
</body>
</html>