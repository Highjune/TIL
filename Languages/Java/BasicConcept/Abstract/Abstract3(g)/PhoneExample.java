package test;

public class PhoneExample {
	public static void main(String[] args) {
//		Phone phone = new Phone(); // 안됨. Phone은 추상클래스이므로 new로 객체 생성 불가
		
		SmartPhone smartPhone = new SmartPhone("June");
		
		smartPhone.turnOn(); //폰 전원을 켭니다.
		smartPhone.internetSearch(); //인터넷 검색을 한다.
		smartPhone.turnOff(); //폰 전원을 끕니다.

	}
}
