import java.util.Stack;

//TestŬ������ �Բ�

//�ڹ��� ���� p679�� ����
public class GenericDemo {
	public static void main(String[] args) {
//		Test <Integer> t = new Test <Integer>(5);
//		Test <String> t1 = new Test <String>("Hello"); 
		//��������. �ֳ��ϸ� Test T�� number�� �ڽ����� �ױ� ������ ���ڸ� �����ϴ�.
	
		Stack <String> stack = new Stack<String> ();
		Stack <Object> obj = new Stack<Object> ();
		Stack<Integer> in = new Stack<Integer>();
		Stack<? extends Number> wild = in;
		
//		Stack<?> wild = stack; //stack�� String���� wild������ �������.
		//wild�� ��� ���� �� ���� �� �ִ�. �θ����� ����� ���� ����wild�� �������. ex) sonata stack, fruit stack �� ���� �� ����. 
		//�׷��� ���� ���� �ϸ� �ʹ� �� �����ϱ� ������ �α� �����Ѵ�. �Ʒ��� ����
//		Stack<? extends Number> wild = stack; //�̷��� ���� �θ� ��������.
		
//		Object o = new String();
//		obj = stack; //���ʸ� ���迡���� ����ȯ�� �ȵȴ�. �׷��� ���� ���� ?�� ���� ����� �ִ�.
		
	
	}
}


