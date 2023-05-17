<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="common.Person"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>application 영역</title>
</head>
<body>
	<h2>application 영역의 속성 읽기</h2>
	<%
	Map<String, Person> maps = (Map<String, Person>) application.getAttribute("maps");
	Set<String> keys = maps.keySet();
	for (String key : keys) {
		Person person = maps.get(key);
		out.print(String.format("Key: %s , 이름 : %s, 나이 : %d<br/>", key, person.getName(), person.getAge()));
	}

	Map<String, Object> maps1 = (Map<String, Object>) application.getAttribute("maps1");
	Set<String> keys1 = maps1.keySet();
	for (String key : keys1) {
		Object object = maps1.get(key);
		if (object instanceof Person) {//person 타입 캐스팅. 자기에게 맞는 타입으로 캐스팅. 오브젝트가 어떤 타입인지 잘 체크!!
			Person person = (Person) object;
			out.print(String.format("Key: %s, 이름 : %s, 나이 : %d<br/>", key, person.getName(), person.getAge()));
		} 
		
		else if (object instanceof ArrayList) { //어레이 타입 객체면, 어레이 타입으로 타입 캐스팅하고, 리스트로 바꾸고 출력.
			ArrayList<String> lists = (ArrayList<String>) object;
			for (String s : lists) {
		out.print(String.format("Key: %s, 이름 : %s<br/>", key, s));
			}
		}
		else {
			out.print(String.format("Key: %s, Value : %s<br/>", key, object));
		}
	}
	%>

</body>
</html>