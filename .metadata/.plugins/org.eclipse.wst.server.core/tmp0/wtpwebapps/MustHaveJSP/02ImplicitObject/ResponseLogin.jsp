<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html><head>

<title>내장 객체 - Response</title></head>
<body>
<%
String id = request.getParameter("user_id"); //실행만 하고 뭘 보여주는 코드가 없는 파일.
String pwd = request.getParameter("user_pwd");
if (id.equalsIgnoreCase("must") && pwd.equalsIgnoreCase("1234")){
response.sendRedirect("ResponseWelcome.jsp");// 브라우저에서 서버의 기능을 호출하려고 실행(login.jsp) 했는데 아이디 패스워드 안맞아서
//sendRedirect 호출. 다시 연결하라고 ResponseWelcome.jsp 이 페이지로. 이 페이지를 호출을 다시 해라. ResponseWelcome 다시 보낸다.
// B(브라우저)->S(서버)->B->S 총 2번 왔다갔다. 통신량은 sendRedirect 이게 더 많다.
}
else{
request.getRequestDispatcher("ResponseMain.jsp?loginErr=1").forward(request,response);
//reward는 브라우저에서 s로 보내면 S 내에서 또 아래로 보내고 B로 보내주고 끝. 1번만 왔다갔다

//ResponseMain.jsp?loginErr=1 null 아니다. 뭔가 값은 있다. 
//이 loginErr=1 값은 ResponseMain에 String~("loginErr") 이부분에 1이 들어간다.
//null이 아니니까 로그인 실패 뜸
}
%>

</body>
</html>