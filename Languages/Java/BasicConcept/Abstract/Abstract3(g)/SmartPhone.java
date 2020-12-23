package test;

public class SmartPhone extends Phone{
	
	public SmartPhone(String owner) {
		super(owner); // 추상클래스면서 부모클래스인 Phone 생성자 호출.
	}
	
	public void internetSearch() {
		System.out.println("인터넷 검색을 한다.");
	}
	
	
	
}
