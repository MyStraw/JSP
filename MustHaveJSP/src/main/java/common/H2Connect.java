package common; //jsp로도 테이블을 빼내보자.

//어레이 리스트로 한행 자체를 다 데이터로

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.jsp.JspWriter;

public class H2Connect {

	private String driver = null;
	private String url = null;
	private String id = null;
	private String pwd = null;
	
	public H2Connect() {		
	}
	
	public H2Connect(String driver, String url, String id, String pwd) {
		this.driver=driver;
		this.url=url;
		this.id=id;
		this.pwd=pwd; //생성자에 파라미터 받아오기.
	}	
	

	public Connection getConnection() throws Exception {
		Class.forName(driver);
		return DriverManager.getConnection(url, id, pwd);
	}
	

	public void writeDeptToTable(Connection con, JspWriter out) {
		Statement st = null;
		ResultSet rs = null;

		try {
			out.write("<table border=\"1\">");
			out.write("<tr>");
			out.write("<td>DNO</td><td>DNAME</td><td>BUDGET</td>");
			out.write("</tr>");

			st = con.createStatement();
			rs = st.executeQuery("select * from dept");
			while (rs.next()) {
				out.write("<tr>");
				out.write("<td>");
				out.write(rs.getString("DNO"));
				out.write("</td>");
				out.write("<td>");
				out.write(rs.getString("DNAME"));
				out.write("</td>");
				out.write("<td>");
				out.print(rs.getInt("BUDGET"));
				out.write("</td>");				
				out.write("</tr>");
			}
			out.write("</table>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} catch (Exception e) {
			}
		}
	}	

	public static void main(String[] args) throws Exception {
		H2Connect h2connect = new H2Connect();
		Connection con = h2connect.getConnection();		
		con.close();
	}
	
}
