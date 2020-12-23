package test;

public class BoxingUnBoxingExample {
	public static void main(String[] args) {
		// 박싱하는 방법 3가지
		// 포장 클래스의 생성자 매개값으로 기본 타입의 값 또는 문자열 넘겨주면 된다.
		// 또는 각 포장 클래스마다 가지고 있는 valueOf()메서드를 이용하면 된다.
		Integer obj1 = new Integer(100);
		Integer obj2 = new Integer("200");
		Integer obj3 = Integer.valueOf("300");

		
		//언박싱
		//박싱된 포장 객체에서 다시 기본 타입의 값을 얻어내기 위해서는 각 포장 클래스마다 가지고 있는 "기본타입이름+Value()" 메서드 호출하면 된다.
		int value1 = obj1.intValue();
		int value2 = obj2.intValue();
		int value3 = obj3.intValue();
		
		System.out.println(value1); //100
		System.out.println(value2); //200
		System.out.println(value3); //300
		
	}
}
