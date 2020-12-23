
public class HelloWorld4 {
	public static void main(String[] args) {
		System.out.println(Demo.msg);
	
}
}


class Demo{
	static String msg = "Hello, World"; //static variable. 그래서 다른 곳(위)에서 여기에 접근할 때는 클래스 변수로 접근
	
}

////HelloWorld를 출력하는 8가지 방법 중, 지금 4번째까지는 다 변수로. 5번부터는 메소드 사용