public class HelloWorld3 {
	public static void main(String[] args) {
		Test t = new Test(); 
		System.out.println(t.msg);
//		System.out.println(new Test().msg); // 이렇게 해도 된다
	
	}

}
class Test{
	String msg ="Hello, World"; //멤버변수(클래스 안에 있는데 static이 없으면 멤버, 그리고 다른 곳(위)에서 불러내려면 생성해야 된다 new~)
}






