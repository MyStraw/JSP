package common; //jsp로도 테이블을 빼내보자.

//어레이 리스트로 한행 자체를 다 데이터로

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspWriter;

public class JDBCConnect2 {

	private String driver;
	private String url;
	private String id;
	private String pwd;

	public JDBCConnect2() {

		driver = "com.mysql.cj.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/musthave";
		id = "musthave";
		pwd = "tiger";
	}

	public JDBCConnect2(String driver, String url, String id, String pwd) {
		this.driver = driver;
		this.url = url;
		this.id = id;
		this.pwd = pwd; // 생성자에 파라미터 받아오기.
	}

	public JDBCConnect2(ServletContext app) {
		driver = app.getInitParameter("MySQLDriver");
		url = app.getInitParameter("MySQLURL");
		id = app.getInitParameter("MySQLId");
		pwd = app.getInitParameter("MySQLPwd");	
			
	}

	public Connection getConnection() {
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, id, pwd);
			
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public void closeConnection(Connection con) {
		try {
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//
//	public Connection getConnection() throws Exception {
//		Class.forName(driver);
//		return DriverManager.getConnection(url, id, pwd);
//	}
//
//	public void writeMemberToTable(Connection con, JspWriter out) {
//		Statement st = null;
//		ResultSet rs = null;
//
//		try {
//			out.write("<table border=\"1\">");
//			out.write("<tr>");
//			out.write("<td>id</td><td>pass</td><td>name</td><td>regidate</td>");
//			out.write("</tr>");
//
//			st = con.createStatement();
//			rs = st.executeQuery("select * from member");
//			while (rs.next()) {
//				out.write("<tr>");
//				out.write("<td>");
//				out.write(rs.getString("id"));
//				out.write("</td>");
//				out.write("<td>");
//				out.write(rs.getString("pass"));
//				out.write("</td>");
//				out.write("<td>");
//				out.write(rs.getString("name"));
//				out.write("</td>");
//				out.write("<td>");
//				out.write(rs.getString("regidate"));
//				out.write("</td>");
//				out.write("</tr>");
//			}
//			out.write("</table>");
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (st != null)
//					st.close();
//			} catch (Exception e) {
//			}
//		}
//	}
//	
//	public void wtiteBoardToTable(Connection con, JspWriter out) {
//		Statement st = null;
//		ResultSet rs = null;
//
//		try {
//			out.write("<table border=\"1\">");
//			out.write("<tr>");
//			out.write("<td>num</td><td>title</td><td>content</td><td>id</td><td>postdate</td><td>visitcount</td>");
//			out.write("</tr>");
//
//			st = con.createStatement();
//			rs = st.executeQuery("select * from board");
//			while (rs.next()) {
//				out.write("<tr>"); out.write("<td>"); out.print(rs.getInt("num")); out.write("</td>");
//				out.write("<td>"); out.write(rs.getString("title")); out.write("</td>");
//				out.write("<td>"); out.write(rs.getString("content")); out.write("</td>");
//				out.write("<td>"); out.write(rs.getString("id")); out.write("</td>");
//				out.write("<td>"); out.print(rs.getTimestamp("postdate")); out.write("</td>");
//				out.write("<td>"); out.print(rs.getInt("visitcount")); out.write("</td>");
//				out.write("</tr>");
//			}
//			out.write("</table>");
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (st != null)
//					st.close();
//			} catch (Exception e) {
//			}
//		}
//	}
//
//	public static void main(String[] args) throws Exception {
//		JDBCConnect jdbcConnect = new JDBCConnect();
//		Connection con = jdbcConnect.getConnection();
//		jdbcConnect.printBoard(con);
//		con.close();
//	}
//
//	public void printBoard(Connection con) throws Exception {
//		Statement st = con.createStatement();
//		ResultSet rs = st.executeQuery("select * from board");
//		while (rs.next()) {
//			System.out.println(String.format("%5d\t%s\t%s\t%8s\t%s\t%d\n", rs.getInt("num"), rs.getString("title"),
//					rs.getString("content"), rs.getString("id"), rs.getTimestamp("postdate"), rs.getInt("visitcount")));
//		}
//		rs.close();
//		st.close();
//	}
}
