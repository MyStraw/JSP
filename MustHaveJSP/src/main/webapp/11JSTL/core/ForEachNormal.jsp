<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>JSTL - forEach 1</title>
</head>
<body>
	<h4>일반 for문 형태의 forEach 태그</h4>
	<c:forEach begin="1" end="3" step="1" var="i">
		<p>반복 ${ i }입니다</p>
	</c:forEach>

	<h4>varStatus 속성 살펴보기</h4>
	<table border="1">
		<c:forEach begin="3" end="5" var="i" step ="1" varStatus="loop">
		<%
		//for (int i = 3; i<=5 ; i++) 이거랑 같은 식. step="2" 이면 i+=2이다. 없으면 디폴트 1
		%>
			<tr>
				<td>count : ${ loop.count }</td> <!-- loop 돌때마다 count가 1부터 증가. 1,2,3 나오겄지? -->
				<td>index : ${ loop.index }</td> <!-- 인덱스값, 3,4,5 나옴 -->
				<td>current : ${ loop.current }</td> <!-- 현재 인덱스 값을 찍는다. index랑 current 값이 같아지는데, but 확장된 for 쓰면 인덱스가 아닌 들어온 값을 이용. 391페이지 -->
				<td>first : ${ loop.first }</td>
				<td>last : ${ loop.last }</td>
			</tr>
		</c:forEach>
	</table>

	<h4>1에서 100까지 정수 중 홀수의 합</h4>
	<c:forEach begin="1" end="100" var="j">
		<c:if test="${j mod 2 ne 0 }">
			<c:set var="sum" value="${ sum + j }" />
		</c:if>
	</c:forEach>
	<%
		//for (int j = 1 ; j<100 ; j++)
	//		if(j%2 != 0){			
	//		}
	%>
	1~100 사이의 정수 중 홀수의 합은? ${ sum }
</body>
</html>