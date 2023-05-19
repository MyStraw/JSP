package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

public class JDBConnect {	

	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	
//	private String driver ="com.mysql.cj.jdbc.Driver";
//	private String url = "jdbc:mysql://localhost:3306/musthave";
//	private String id = "musthave";
//	private String pwd = "tiger";
			

	public JDBConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/musthave";
			String id = "musthave";
			String pwd = "tiger";
			con = DriverManager.getConnection(url, id, pwd);

			System.out.println("DB 연결 성공(기본 생성자)");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (psmt != null)
				psmt.close();
			if (con != null)
				con.close();

			System.out.println("JDBC 자원 해제");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		JDBConnect jdbconnect = new JDBConnect();
		jdbconnect.showTable();
		jdbconnect.close();
	}

	public JDBConnect(String driver, String url, String id, String pwd) {

	}

	public void showTable() {

		try {
			String query = "select * from board";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				int num = rs.getInt(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				String id = rs.getString(4);
				Timestamp postdate = rs.getTimestamp(5);
				int visitcount = rs.getInt(6);

				System.out.printf("%5d\t%s\t%s\t%8s\t%s\t%d\n", num, title, content, id, postdate, visitcount);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
