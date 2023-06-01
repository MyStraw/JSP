<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%!public int add(int num1, int num2) {
		return num1 + num2;

	}%>
<!-- 여기에 메소드 -->
<html>
<head>
<title>스크립트 요소</title>
</head>
<body>
	<%
	int result = add(10, 20);
	int num1 = 0;
	int num2 = 0;
	String numst1 = request.getParameter("num1");
	if (numst1 != null)
		num1 = Integer.parseInt(numst1);
	String numst2 = request.getParameter("num2");
	if (numst2 != null)
		num2 = Integer.parseInt(numst2);
	%>
<!-- 여기위에는 코드블럭

	여기 아래엔 표현식. 실행 결과로 하나의 값이 남는 문장. java랑 약간 다르네~ 반환값 있는 메소드 호출등 모두 표현식에 속한다. 
	코드블럭 안(위)에선 out.print()를 하지만 여기선 좀더 단순한 방법으로 출력한다.-->
	
	덧셈 결과 1 :
	<%=result%>
	<br /> 덧셈 결과 2 :
	<%=add(30, 40)%>
	<br /> 덧셈 결과 3 :
	<%=add(num1, num2)%>
	<!-- 반환값이 있는 메소드 호출을 한거다. 위에 add 메소드를 만들고 코드블럭에서 num1을 지정해주고 그걸 파라미터로 넘기고 더하기를 한뒤 반환 -->
</body>
</html>