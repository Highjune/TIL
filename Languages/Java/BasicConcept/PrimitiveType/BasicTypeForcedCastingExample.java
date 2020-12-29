package practice;

//강제형변환
//큰 허용범위 타입 -> 작은 허용범위 타입
public class BasicTypeForcedCastingExample {
	public static void main(String[] args) {
		int intValue = 44032;
		char charValue = (char)intValue; // for printing letter(from number)
		System.out.println(charValue);
		
		long longValue = 500;
		intValue = (int)longValue;
		System.out.println(intValue); //500
		
		double doubleValue = 3.14;
		intValue = (int) doubleValue;
		System.out.println(intValue); //3
	}
}	
