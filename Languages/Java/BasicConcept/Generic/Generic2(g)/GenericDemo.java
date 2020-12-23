import java.util.Stack;

//Test클래스와 함께

//자바의 정석 p679의 설명
public class GenericDemo {
	public static void main(String[] args) {
//		Test <Integer> t = new Test <Integer>(5);
//		Test <String> t1 = new Test <String>("Hello"); 
		//에러난다. 왜냐하면 Test T를 number의 자식으로 뒀기 때문에 숫자만 가능하다.
	
		Stack <String> stack = new Stack<String> ();
		Stack <Object> obj = new Stack<Object> ();
		Stack<Integer> in = new Stack<Integer>();
		Stack<? extends Number> wild = in;
		
//		Stack<?> wild = stack; //stack의 String형이 wild형으로 만들었음.
		//wild는 모든 것을 다 받을 수 있다. 부모형을 만들기 위해 만능wild를 만들었음. ex) sonata stack, fruit stack 다 받을 수 있음. 
		//그런데 위와 같이 하면 너무 다 받으니까 제한을 두기 시작한다. 아래와 같이
//		Stack<? extends Number> wild = stack; //이렇게 제한 두면 에러난다.
		
//		Object o = new String();
//		obj = stack; //제너릭 세계에서는 형변환이 안된다. 그래서 위와 같이 ?와 같은 기능이 있다.
		
	
	}
}


