<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% //1. 그냥 먼저 해보기(1800). 2.web.xml 수정하고 해보기, 3. 둘다 없애고 해보기. 할때 창 다 닫고 하기! 서버를 재부팅 해야 web.xml이 리로드

//session.setMaxInactiveInterval(1800);

SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
long creationTime = session.getCreationTime();
String creationTimeStr = dateFormat.format(new Date(creationTime));

long lastTime = session.getLastAccessedTime();
String lastTimeStr = dateFormat.format(new Date(lastTime));
%>
<html>
<head><title>Session</title></head>
<body>
<h2>Session 설정 확인</h2>
<ul>
<li>세션 유지 시간 : <%= session.getMaxInactiveInterval() %></li>
<li>세션 아이디 : <%= session.getId() %></li>
<li>최초 요청 시각 : <%= creationTimeStr %></li>
<li>마지막 요청 시각 : <%= lastTimeStr %></li>

</ul>

</body>
</html>