package practice;

public class OperationsPromotionExample {
	public static void main(String[] args) {
		byte byteValue1 = 10;
		byte byteValue2 = 20;
		//byte byteValue3 = byteValue1 + byteValue2; // 컴파일 에러(int보다 작은 정수 타입 변수의 연산은 무조건 int타입으로 자동 타입 변환)
		int intValue1 = byteValue1 + byteValue2;
		System.out.println(intValue1); //30
		
		char charValue1 = 'A';
		char charValue2 = 1;
//		char charValue3 = charValue1 + charValue2; // 컴파일 에러(int보다 작은 정수 타입 변수의 연산은 무조건 int타입으로 자동 타입 변환)
		int intValue2 = charValue1 + charValue2;
		System.out.println("유니코드 = " + intValue2); // 유니코드 = 66
		System.out.println("출력문자 = " + (char)intValue2); // 출력문자 = B
		
		int intValue3 = 10;
		int intValue4 = intValue3/4;
		System.out.println(intValue4); // 2 (int로 형변환)
		
		int intValue5 = 10;
		//int intValue6 = 10 / 4.0 // 컴파일 에러(10과 double타입인 4.0을 연산하므로 double 타입 변수로 연산 결과를 받아야 한다.
		double doubleValue = intValue5 / 4.0;
		System.out.println(doubleValue); // 2.5
		
		int x = 1;
		int y = 2;
		double result = (double)x/y; 
		double result1 = (double)(x/y); 
		System.out.println(result); // 0.5
		System.out.println(result1); // 0.0 (x/y)가 먼저 연산이 되어 0이 되고 그 결과에 (double)0 을 적용해서 0.0이 되기 때문
		
		
	}
}
