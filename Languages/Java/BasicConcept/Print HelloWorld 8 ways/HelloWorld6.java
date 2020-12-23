
public class HelloWorld6 {
	public static void main(String[] args) {
//		HelloWorld6.display(); 원래는 이렇게 해야 하나 동일클래스인 경우에는, 생략가능
		display(); //static라서 바로 사용 가능
	}
	static void display() { //static method
		System.out.println("Hello, World");
	}
}




