
public class HelloWorld5 {
	public static void main(String[] args) {
		HelloWorld5 hw = new HelloWorld5();
		hw.display();
		
	}
	void display() { // member method. 다른 곳(위)에서 부를 때 member가 들어갔으니 'new'로 생성. 주소로 접근한다.
		System.out.println("Hello, World");
	}
}
