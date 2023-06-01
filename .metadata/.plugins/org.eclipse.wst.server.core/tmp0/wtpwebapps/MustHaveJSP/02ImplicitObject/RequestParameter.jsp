<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head><title>내장 객체 - request</title>
</head>
<body>
<% 
request.setCharacterEncoding("UTF-8");
String id = request.getParameter("id"); //브라우저 통해 뭐 달라~ 할때 뭐달라 하는건지 옵션을 말하는거. 중요!!
String sex = request.getParameter("sex");
String[] favo = request.getParameterValues("favo");
String favoStr = ""; // id, sex, favo등 메인에서 파라미터 넣은 값들이 여기 들어와서 각각 인수로 들어가는데, 메인에서 입력 안해도 null값이 입력이 되어서 괜찮지만
if (favo !=null){
for (int i = 0; i< favo.length; i++) {
	favoStr += favo[i] + " ";
}
}
String intro = request.getParameter("intro").replace("\r\n","<br/>"); // 여기때문에 에러가 난다. null값이 위에까진 괜찮았지만
//null.replace 이거때문에 안된다. null은 객체가 아니다. 이거땜에 에러가 난다.
%>
<ul>
<li>아이디 : <%= id %></li>
<li>성별 : <%= sex %></li>
<li>관심사항 : <%= favoStr %></li>
<li>자기소개 : <%= intro %></li>

</ul>
</body>
</html>