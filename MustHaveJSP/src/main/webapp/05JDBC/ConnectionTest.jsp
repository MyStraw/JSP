

<%@page import="common.H2Connect"%>
<%@page import="java.sql.Connection"%>
<%@page import="common.JDBCConnect"%>
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
	JDBCConnect jdbc1 = new JDBCConnect(); //객체 만들고, 이걸로 연결
//	JDBCConnect jdbcConnect1 = new JDBCConnect( JDBCconnect3.java 파일 보기.
//			"com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/musthave",
//			"musthave","tiger"); //이러면 외부에서 설정. 대신 이건 보안이... 비번이 보인다.
			//생성자에 파라미터를 넘기는 식으로 할때의 차이. 그리 적절한 방식은 아니다.
			//그냥 기본생성자로 하면 db이름이나 아이디 비번 수정이 어렵다. 이건 변경은 쉽지만
			//만약 jsp가 100개라면? 그리고 db가 바뀌면? 일일이 다 바꿔야..
	
	Connection con = jdbc1.getConnection();
	%>	
	<h1>Member</h1>
	<%	
	jdbc1.writeMemberToTable(con, out);	//jsp 에서 out 해주는 내장객체 존재.
	%>
	<h1>Board</h1>
	<%	
	jdbc1.wtiteBoardToTable(con, out);
	con.close(); 
	%>
	
	
	<h2>JDBC 테스트 2</h2>	
	
	<%
	//web.xml 에 입력해놨을때.
	String driver = application.getInitParameter("MySQLDriver");
	String url = application.getInitParameter("MySQLURL");
	String id = application.getInitParameter("MySQLID");
	String pwd = application.getInitParameter("MySQLPwd");
	JDBCConnect jdbc2 = new JDBCConnect(driver, url, id, pwd);
	Connection con2 = jdbc1.getConnection();
	jdbc2.writeMemberToTable(con2, out);	
	jdbc2.wtiteBoardToTable(con2, out);	 
	con2.close();
	%>	
	
	<h2>H2 테스트 2</h2>	
	
	<%
	//web.xml 에 입력해놨을때. web.xml에서 읽어온다. H2Connect.java에는 다 null 해놨다.
	String drivers = application.getInitParameter("H2Driver");
	String urls = application.getInitParameter("H2URL");
	String ids = application.getInitParameter("H2ID");
	String pwds = application.getInitParameter("H2Pwd");
	
	H2Connect h2Connect = new H2Connect(drivers, urls, ids, pwds);
	
	Connection con1 = h2Connect.getConnection();	
	
	h2Connect.writeDeptToTable(con1, out);	 
	
	con1.close();
	%>	
	

</body> 
</html>