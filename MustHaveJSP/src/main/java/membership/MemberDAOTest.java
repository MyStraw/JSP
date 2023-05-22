package membership;

import java.util.ArrayList;

public class MemberDAOTest {

	private static MemberDAO memberDAO = new MemberDAO();

	public static void printMemberDTO() {
		// Test getMemberDTO()
		MemberDTO memberDTO = memberDAO.getMemberDTO("test1", "1111");
		System.out.println(memberDTO);

	}

	public static void printAllMemberDTO() {
		// Test getAllMemberDTO()
		ArrayList<MemberDTO> list = memberDAO.getAllMemberDTO();
		for (MemberDTO m : list) {
			System.out.println(m);
		}
	}
	
	public static void insertMemberObjectDTO() {
		MemberDTO memberDTO = memberDAO.insertMemberDTO("jeong", "3323", "돈해브");		
	}

	public static void insertMemberDTO() {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("Hong"); // 객체를 만들어서 세터로 호출. 이게 값 넣어주는거네.
		memberDTO.setPass("1234");
		memberDTO.setName("홍길동");
		memberDAO.insertMemberDTO(memberDTO);
	}	
	
	
	public static void updateMemberDTO() {
		MemberDTO memberDTO = memberDAO.insertMemberDTO("jeong", "3323", "돈해브");	
	}
	
	public static void deleteMemberDTO() {
		int memberDTO = memberDAO.deleteMemberDTO("jeong");	
	}

	// static 인스턴스 생성없이 호출가능.
	public static void main(String[] args) {

//		printMemberDTO();
//		printAllMemberDTO();
//
//		System.out.println("-".repeat(80));
//
//		insertMemberDTO();
//		printAllMemberDTO();
//		System.out.println("-".repeat(80));
//		insertMemberObjectDTO();
		deleteMemberDTO();
		printAllMemberDTO();

	}

}
