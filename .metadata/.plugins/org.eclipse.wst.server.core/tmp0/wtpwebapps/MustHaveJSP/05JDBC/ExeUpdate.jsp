<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBCConnect2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>JDBC</title>
</head>
<body>
	<h2>회원 추가 테스트(executeUpdate() 사용)</h2>
	<%
	JDBCConnect2 jdbc = new JDBCConnect2();
	Connection con = jdbc.getConnection();
	if(con ==null) {
		out.print("<h2>Fail to Connect DB~~~<h2>");
		return;
	}

//	String id = "test1"; //값 고정 = 하드코딩.
//	String pass = "1111";
//	String name = "테스트1회원";
	
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String name = request.getParameter("name");
//이렇게 책에서 해보라 되어있는데, 이러면 주소창에 	
	if (id == null){
		out.print("<h2>input data is invalid~~~<h2>");
		return;
	}

	String sql = "INSERT INTO member(id,pass,name) VALUES (?, ?, ?)";
	
	PreparedStatement psmt = con.prepareStatement(sql);
	psmt.setString(1, id);
	psmt.setString(2, pass);
	psmt.setString(3, name);

	int inResult = psmt.executeUpdate(); //몇개~? 입력~?
	out.print(inResult + "행이 입력되었습니다.");

	
	psmt.close();
	jdbc.closeConnection(con);
	%>

</body>
</html>