package common; // 기본 패키지 이외의 패키지 규약 1번

public class Person {
	private String name; //멤버 변수는 private로 한다. 규약2번
	private int age;

	public Person() { //기본 생성자 규약 3번.

	}

	public Person(String name, int age) { //얘만 있으면 기본생성자 없이는  x. 아예 둘다 없던가. 기본생성자만 가능.
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() { // public 게터/세터 메서드들. 규약4, 5번.
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
