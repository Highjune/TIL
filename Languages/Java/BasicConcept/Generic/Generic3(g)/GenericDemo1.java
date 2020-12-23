import java.util.Stack;
import java.util.Collections;


//Car클래스와 함께

public class GenericDemo1 {
	public static void main(String[] args) {
//		Stack stack = new Stack(); //제너릭 제거했을 때 이렇게 된다.
//		stack.push(5);        //원래는 이렇게 다 넣어도 된다. 그런데...
//		stack.push(89.5);
//		stack.push("Hello");
//		int num = (Integer)stack.pop();
//		System.out.println(num);
		
		Stack<Car> stack = new Stack<Car>();
		stack.push(new Car("소나타", 25_000_000));
		stack.push(new Car("카니발", 30_000_000));
		stack.push(new Car("마티즈", 15_000_000));
		stack.push(new Car("Bentz", 125_000_000));
		
		System.out.println(stack.pop());  //
		Collections.sort(stack); //소팅(가격 기준으로 하라고 우리가 미리 설정)
		System.out.println(stack.pop());
	}
}



