

<%@page import="common.H2Connect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2>H2 테스트 2</h2>	
	
	<%
	//web.xml 에 입력해놨을때. web.xml에서 읽어온다. H2Connect.java에는 다 null 해놨다.
	String driver = application.getInitParameter("H2Driver");
	String url = application.getInitParameter("H2URL");
	String id = application.getInitParameter("H2ID");
	String pwd = application.getInitParameter("H2Pwd");
	
	H2Connect h2Connect = new H2Connect(driver, url, id, pwd);
	
	Connection con1 = h2Connect.getConnection();	
	
	h2Connect.writeDeptToTable(con1, out);	 
	
	con1.close();
	%>	
	

</body> 
</html>