import java.util.Stack;
import java.util.Collections;


//CarŬ������ �Բ�

public class GenericDemo1 {
	public static void main(String[] args) {
//		Stack stack = new Stack(); //���ʸ� �������� �� �̷��� �ȴ�.
//		stack.push(5);        //������ �̷��� �� �־ �ȴ�. �׷���...
//		stack.push(89.5);
//		stack.push("Hello");
//		int num = (Integer)stack.pop();
//		System.out.println(num);
		
		Stack<Car> stack = new Stack<Car>();
		stack.push(new Car("�ҳ�Ÿ", 25_000_000));
		stack.push(new Car("ī�Ϲ�", 30_000_000));
		stack.push(new Car("��Ƽ��", 15_000_000));
		stack.push(new Car("Bentz", 125_000_000));
		
		System.out.println(stack.pop());  //
		Collections.sort(stack); //����(���� �������� �϶�� �츮�� �̸� ����)
		System.out.println(stack.pop());
	}
}



