
//override연습한 것임. Point 에서 equals의 메소드를 재정의 해서 쓴 것임.

public class OverrideDemo1 {
	public static void main(String[] args) {
		Point original = new Point(40, 80);
		System.out.println(original);
		Point other = new Point(40, 80);
//		System.out.println(original.equals(other));  
// 		Object의 한 객체인 equals를 사용한 것임. equals는 주소비교하는 것이기 때문에 original과 other의 주소가 다르니 false;
		System.out.println(original.equals(other));  // 위는 false, 아래는 true. 아래는 point 클래스에서 재정의(값으로 비교하게)한 뒤에 결과 비교.
		//즉 equals는 원래 주소를 비교하는데 재정의해서 값비교하는 것으로 바꾼 것임.
	
		
		
		
}
	
	
}
