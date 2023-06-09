package fileupload;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import common.JDBCConnect2;

public class MyfileDAO extends JDBCConnect2 {

	public int insertFile(MyfileDTO dto) {

		int applyResult = 0;

		String query = "insert into myfile(name, title, cate, ofile, sfile) values (?,?,?,?,?)";
		Connection con = getConnection();

		if (con == null) {
			return 0;
		}
		PreparedStatement psmt = null;

		try {

			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getCate());
			psmt.setString(4, dto.getOfile());
			psmt.setString(5, dto.getSfile());

			applyResult = psmt.executeUpdate();

			con.close();

		} catch (Exception e) {
			System.out.println("INSERT 중 예외 발생");
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return applyResult;
	}

	public List<MyfileDTO> myFileList(){
		List<MyfileDTO> fileList = new Vector<MyfileDTO>();
		Connection con = getConnection();
		
		String query = "select * from myfile order by idx desc";
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				MyfileDTO dto = new MyfileDTO();
				dto.setIdx(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setCate(rs.getString(4));
				dto.setOfile(rs.getString(5));
				dto.setSfile(rs.getString(6));
				dto.setPostdate(rs.getString(7));
				
				fileList.add(dto);
			}			
		}
		catch (Exception e) {
			System.out.println("SELECT 시 예외 발생");
			e.printStackTrace();
		}
		return fileList;
	}
	
	
//	public static void main(String[] args) {
//		
//		//2. 입력할 DTO객체를 만들고. 이런식으로 주석으로 적어보면서 해
//		MyfileDTO mydto = new MyfileDTO();
//		
//		//3. 입력할 내용을 DTO 객체에 설정하고
//
//		mydto.setName("Gil");
//		mydto.setTitle("nahaha");
//		mydto.setCate("human");
//		mydto.setOfile("ofile1");
//		mydto.setSfile("sfile1");
//		
//		
//		//1. 데이터 입력 객체를 만들고
//		MyfileDAO mydao = new MyfileDAO();
//		
//		//4. 데이터 입력
//		mydao.insertFile(mydto);		
//		System.out.println(mydto);
//		
//		System.out.println(mydao.myFileList());
//	}
	
	public static void main(String[] args) {//이 방법도 해봥	
			
			
			MyfileDAO mydao = new MyfileDAO();
			
			mydao.insertFile(new MyfileDTO("a", "b", "c", "d", "e"));		
		
			
			System.out.println(mydao.myFileList());
		
	}
	
}
