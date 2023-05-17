<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
String type = request.getParameter("sel"); //gugudan3에서 name에 있는걸 가져온다.
String dan = request.getParameter("val");

//type 1 이면
if(type.equals("gugudanType1")){ //name에서 올라온 값(value)이 이거일때만.
	response.sendRedirect("gugudan.jsp?num="+dan); //gugudan.jsp 부르면서~
	}

//type 2 이면
if (type.equals("gugudanType2")) {
	response.sendRedirect("gugudan2.jsp?col="+dan);
	}
%>
</body>
</html>