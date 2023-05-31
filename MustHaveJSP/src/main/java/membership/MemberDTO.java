package membership;

import java.io.Serializable;

public class MemberDTO implements Serializable { //마크인터페이스. 시리얼라이즈 직렬화 해서 파일에 쓰고 읽고 할수있게 마킹. 이런 마킹이 붙어있어야 읽고 쓰고 가능.
		
	private static final long serialVersionUID = 1L; //디스크에 특정 객체 write 하고 읽을때 검증목적. 쓰거나 읽을 목적이 없으면 이거 필요없다.
	
	//멤버 변수 선언
	private String id;
	private String pass;
	private String name;
	private String regidate;
	
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public MemberDTO(String id, String pass, String name, String regidate) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.pass=pass;
		this.name=name;
		this.regidate=regidate;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}

	public String getRegidate() {
		return regidate;
	}

	public void setRegidate(String regidate) {
		this.regidate = regidate;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pass=" + pass + ", name=" + name + ", regidate=" + regidate + "]";
	}	

}
