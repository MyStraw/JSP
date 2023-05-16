<%@ page import="common.Person" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    pageContext.setAttribute("pageInteger",1000);
    pageContext.setAttribute("pageString", "페이지 영역의 문자열"); // pageString 이라는 정보를 pageContext에 저장,배열객체도 저장이 되겠네.
    pageContext.setAttribute("pagePerson", new Person("한석봉", 99));//pageContext 안에 정보 저장. set. map 형태의 자료 구조. 객체를 저장.
    %>
<html>
<head><title>page 영역</title></head>
<body>
<h2>page영역의 속성값 읽기</h2>
<%
int pInteger = (Integer)(pageContext.getAttribute("pageInteger")); //위에서 세팅하고 여기서 저장... 으잉?
String pString = pageContext.getAttribute("pageString").toString();
Person pPerson = (Person)(pageContext.getAttribute("pagePerson"));
%>
<ul>
<li>Integer 객체 : <%= pInteger %></li>
<li>String 객체 : <%= pString %></li>
<li>Person 객체 : <%= pPerson.getName() %>, <%= pPerson.getAge() %></li>
</ul>

<h2>include된 파일에서page영역 읽어오기</h2>
<%@ include file="PageInclude.jsp" %> <!-- jsp를 자바로 컨버젼 하는 시점에 집어넣어 버린다. include 역할. PageInclude.jsp 도 pageContext를 공유. -->
<h2>페이지 이동 후 page 영역 읽어오기</h2>
<a href = "PageLocation.jsp">PageLocation.jsp 바로가기</a> <!-- PageLocation.jsp 에서 pageContext가 새로 만들어진다. 하지만 안에 값들 null. pageContext 값들은 여기서만. -->
</body><!-- get 방식으로 넘어왔으니 pagecontext는 이미 의미없어. null값. -->
</html>