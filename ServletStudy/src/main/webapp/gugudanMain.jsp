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
	//response.sendRedirect("gugudan.jsp?num="+dan); //gugudan.jsp 부르면서~
	request.getRequestDispatcher("gugudan.jsp?num="+dan).forward(request, response);
	}

//type 2 이면
if (type.equals("gugudanType2")) { //이거 없애도 되겠다. else만 하면 돼.
	//response.sendRedirect("gugudan2.jsp?col="+dan);
	request.getRequestDispatcher("gugudan2.jsp?col="+dan).forward(request, response);
	}
//forward와 차이점은, forward 창에서 F5 하면 에러 메세지가 뜬다. 주소 그대로.
//결제시스템 같은걸 할때 이러면 계속 결제가 되겠징
//리다이렉트는 F5 하면 해당 페이지를 계속 새로고침 한다. 주소 바껴


%>
</body>
</html>
