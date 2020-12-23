
public class Method0 {	
	public static void main(String[] args) { 	

	Method0 md = new Method0(); //// static이 붙은 것이 아니므로
	md.print();  //call by name. 함수이름(print)로 불러냈으므로
	
}
//Method의 필수 구성요소 (리턴타입, 이름, 괄호), 근데 괄호가 없으면 변수가 된다. 
	void print() {  //Method's Header
		System.out.println("Hello, World");   //Method's body
	};	
}