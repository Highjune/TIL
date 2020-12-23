package practice;

public class SmartTelevisoinExample {
	public static void main(String[] args) {
		SmartTelevision tv = new SmartTelevision();
		
		//SmartTelevision 클래스는 RemoteControl와 Searchable 인터페이스를 모두 구현했기에 아래와 같이 두 인터페이스 변수로 구현 객체를 바라볼 수 있다.
		RemoteControl rc = tv;
		Searchable searchable = tv;
	}
}
