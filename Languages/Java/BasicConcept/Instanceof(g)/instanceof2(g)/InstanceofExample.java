package test;

public class InstanceofExample {
	
	public static void method1(Parent parent) {
		if(parent instanceof Child) {
			Child child = (Child) parent;
			System.out.println("method1 - Child로 변환 성공");
		} else {
			System.out.println("method1 - Child로 변환되지 않음");
	}
}

	public static void method2(Parent parent) {
			Child child = (Child) parent; // ClasscastException 발생할 가능성 있다 (형변환 가능한지 확인 안 함)
			System.out.println("method2 - Child로 변환 성공");
	}

	public static void main(String[] args) {
		Parent parentA = new Child();
		// 아래 둘 다 child객체를 매개값으로 전달
		method1(parentA); // "method1 - Child로 변환 성공"
		method2(parentA); // "method2 - Child로 변환 성공"
		
		Parent parentB = new Parent();
		// Parent 객체를 매개값으로 전달
		method1(parentB); // "method1 - Child로 변환되지 않음"
		method2(parentB); // 예외 발생(ClassCastException)
	}
}