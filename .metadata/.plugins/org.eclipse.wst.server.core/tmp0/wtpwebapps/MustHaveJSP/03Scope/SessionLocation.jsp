<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head><title>session 영역</title></head>
<body>

<%

ArrayList<?> lists = (ArrayList<?>)session.getAttribute("lists");
if (lists !=null){ //변수로 들어오는게 null인지 확인해서 판단하는 방법
	out.print("<h2>페이지 이동 후 session 영역의 속성 읽기</h2>");
for (Object str : lists)	
	if(str instanceof String)
out.print(str + "<br/>");
}
else

out.print("<h1>Getout!</h1>" + "<br/>");

try{ //예외처리로 하는방법.
ArrayList<String> lists1 = (ArrayList<String>)session.getAttribute("lists");
for (String str : lists1)
out.print(str + "<br/>");
} catch(Exception e){
	//e.printStackTrace();
	System.out.println("Error");
	out.print("<h1>Getout!</h1>");
}
%>
</body>
</html>