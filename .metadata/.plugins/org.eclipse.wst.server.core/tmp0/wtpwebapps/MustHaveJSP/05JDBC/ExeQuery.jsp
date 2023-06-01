<%@page import="common.JDBCConnect2"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC</title>
</head>
<body>
	<h2>회원 목록 조회 테스트(executeQuery() 사용)</h2>
	<%
	JDBCConnect2 jdbc = new JDBCConnect2();
	Connection con = jdbc.getConnection();

	if (con == null) {
		out.print("<h2>Fail to Connect DB~~~<h2>");
		return;
	}

	//쿼리문 생성
	String sql = "SELECT id, pass, name, regidate FROM member";	
	Statement stmt = con.createStatement();
 
	//쿼리문 수행(select 수행엔 executeQuery, insert, update, delete엔 executeUpdate)
	ResultSet rs = stmt.executeQuery(sql);

	//결과 확인(웹 페이지에 출력)
	while (rs.next()) {
		String id = rs.getString(1);
		String pw = rs.getString(2);
		String name = rs.getString("name");
		java.sql.Date regidate = rs.getDate("regidate");

		out.println(String.format("%s %s %s %s", id, pw, name, regidate) + "<br/>");
	}

	rs.close();
	stmt.close();

	jdbc.closeConnection(con);
	%>
</body>
</html>