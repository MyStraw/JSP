package membership;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCConnect2;

public class MemberDAO extends JDBCConnect2 {

	public MemberDAO() { // 기본생성자는 ctrl + space
		// TODO Auto-generated constructor stub
	}

	public MemberDAO(String drv, String url, String id, String pw) {
		super(drv, url, id, pw);
	}

	// executeQuery--------------------------------------------------------------------------
	public MemberDTO getMemberDTO(String uid, String upass) {
		MemberDTO dto = new MemberDTO();
		String query = "SELECT * FROM member WHERE id=? AND pass=?";

		Connection con = getConnection();// 이건 호출마다 연결.(안전하긴 한데 시간이..)
		// 상속받았으니까 바로 가능

		if (con == null) {
			return null;
		}
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			JDBCConnect2 jdbc = new JDBCConnect2();
			psmt = con.prepareStatement(query);
			psmt.setString(1, uid);
			psmt.setString(2, upass);
			rs = psmt.executeQuery();

			if (rs.next()) {

				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));

			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	public ArrayList<MemberDTO> getAllMemberDTO() {

		Connection con = getConnection();// 이건 호출마다 연결.(안전하긴 한데 시간이..)
		// 상속받았으니까 바로 가능

		if (con == null) {
			return null;
		}
		Statement st = null;
		ResultSet rs = null;

		ArrayList<MemberDTO> list = null;

		try {
			JDBCConnect2 jdbc = new JDBCConnect2();
			st = con.createStatement();

			rs = st.executeQuery("SELECT * FROM member");

			list = new ArrayList<>();
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));

				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;

	}

	// executeUpdate------------------------------------------------------------------
	public MemberDTO insertMemberDTO(String id, String pass, String name) {

		MemberDTO memberdto = new MemberDTO();
		String query = "insert into member (id, pass, name) values(?,?,?)";
		Connection con = getConnection();
		if (con == null)
			return null;

		PreparedStatement psmt = null;

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, id);
			psmt.setString(2, pass);
			psmt.setString(3, name);
			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (psmt != null)
					psmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberdto;
	}

	public int insertMemberDTO(MemberDTO member) {

		String query = "insert into member (id, pass, name) values(?,?,?)";

		Connection con = getConnection();
		if (con == null) {
			return 0;
		}
		PreparedStatement psmt = null;

		int ret = 0; //이게 빠졌넹~
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPass());
			psmt.setString(3, member.getName());
			ret = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (psmt != null)
					psmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	public int updateMemberDTO(MemberDTO member) {
		String query = "update member set id =?, pass = ? where name = ?";

		Connection con = getConnection();
		if (con == null) {
			return 0;
		}
		PreparedStatement psmt = null;

		int ret = 0; //이게 빠졌넹~
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPass());
			psmt.setString(3, member.getName());
			ret = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (psmt != null)
					psmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	

	public int deleteMemberDTO(String uid) {
		String query = "delete from member where id = ?";

		Connection con = getConnection();
		if (con == null) {
			return 0;
		}
		PreparedStatement psmt = null;

		int ret = 0; //이게 빠졌넹~
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, "id");			
			ret = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (psmt != null)
					psmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	
}