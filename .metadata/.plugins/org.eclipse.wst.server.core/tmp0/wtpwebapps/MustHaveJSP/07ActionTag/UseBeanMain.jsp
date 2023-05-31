<%@page import="common.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션 태그 - UseBean</title>
</head>
<body>
<h2>useBean 액션 태그</h2>
<h3>자바빈즈 생성하기</h3>
<jsp:useBean id="person" class="common.Person" scope="request" />

<h3>setProperty 액션 태그로 자바빈즈 속성 지정하기</h3>
<jsp:setProperty name="person" property="name" value="임꺽정" />
<jsp:setProperty name="person" property="age" value="41" />

<h3>getProperty 액션 태그로 자바빈즈 속성 읽기</h3>
<ul>
<li>이름 : <jsp:getProperty name="person" property="name" /></li>
<li>나이 : <jsp:getProperty name="person" property="age" /></li>

</ul>

<% 
Person p = new Person();

p.setName("임꺽정");
p.setAge(41);

out.print(p.getName() + "<br>");
out.print(p.getAge() + "<br>");

//이거랑 위에꺼 두개가 같다. 이런 자바코드를 써주는게 액션태그. 자바로 열어서 보면 이게 보일거다.

%>

</body>
</html>