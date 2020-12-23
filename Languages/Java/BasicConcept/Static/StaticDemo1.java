
//public class StaticDemo1 {
//	static int age = getAge();  //제일 먼저 메모리에 올라온다. 그렇게 때문에 getAge도 자동호출
//	public static void main(String[] args) {
//		System.out.println("나는 메인 메소드"); 
//		System.out.println("age = " + age );
//	}
//	
//	static int getAge() {
//		System.out.println("나는 스태틱 메소드");
//		return 24;
//	}
//}


////////  2. static method : 주소없이 메소드 접근하려고


public class StaticDemo1 {
	
	static int age = getAge();  //제일 먼저 메모리에 올라온다. 그렇게 때문에 getAge도 자동호출
	public static void main(String[] args) { //메인은 왜 Static ?? => 주소 없이 접근하기 위해서
//		Tiger tiger = new tiger();
//		Tiger.name
		System.out.println("나는 메인 메소드");
		System.out.println("age = " + age);
	}
	
	static int getAge() {
		StaticDemo1 sd = new StaticDemo1();
		System.out.println("나는 스태틱 메소드");
		return 24;
	}
	
}

class Tiger{
	private Tiger() {} //private붙이면 다른 곳에서 new로 못 만든다. 그래서 static!!!!!!!!
	static String name = "Sally";
}

