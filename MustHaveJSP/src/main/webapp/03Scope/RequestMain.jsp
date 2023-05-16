<%@page import="common.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

String forward = request.getParameter("forward"); //이거 한줄 추가하고

request.setAttribute("requestString", "request 영역의 문자열");
request.setAttribute("requestPerson", new Person("안중근",31));
%>
<html>
<head><title>request 영역</title></head>
<body>
<h2>request 영역의 속성값 삭제하기</h2>
<%
request.removeAttribute("requestString");
request.removeAttribute("requestInteger");
%>
<h2>request 영역의 속성값 읽기</h2>
<%
Person rPerson = (Person)(request.getAttribute("requestPerson"));
%>
<ul>
<li>String 객체 : <%=request.getAttribute("requestString") %></li>
<li>Person 객체 : <%=rPerson.getName() %>, <%=rPerson.getAge() %></li>
</ul>
<h2>포워드된 페이지에서 request 영역 속성값 읽기</h2>
<%
if(forward !=null && forward.equals("1")) //이거 추가하면 주석 해제해도 무조건 포워딩으로 안넘어가고 1 입력해야 넘어가.http://localhost:8080/MustHaveJSP/03Scope/RequestMain.jsp?forward=1
request.getRequestDispatcher(
"RequestForward.jsp?paramHan=한글&paramEng=English")
.forward(request,response);
%> <%--위에꺼 주석안한거랑 한거랑 비교. 주석 안하면 바로 foward로. 자동으로 페이지가 넘어간다. --%>
</body>
</html>