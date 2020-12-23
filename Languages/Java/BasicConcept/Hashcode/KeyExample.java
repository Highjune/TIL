package test;

import java.util.HashMap;

public class KeyExample {
	public static void main(String[] args) {
		//Key 객체를 식별키로 사용해서 String 값을 저장하는 HashMap 객체 생성		
		HashMap<Key, String> hashMap = new HashMap<Key, String>();
		
		//식별키 new Key(1)로 "홍길동"을 저장함
		hashMap.put(new Key(1), "홍길동");
		
		//식별키 new Key(1)로 "홍길동"을 읽어옴
		String value = hashMap.get(new Key(1));
		
		//하지만 읽어오지 못한다.(만약 Key클래스에서 hashCode()메서드를 오버라이딩 하지 않은 상태) 
		//왜냐하면 number 필드값이 같더라도 hashCode()메서드에서 리턴하는 해시코드가 다르므로 다른 식별키로 인식하기 때문이다.
		System.out.println(value); //null 
		
		
	}
}
