import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//Iterator �ڹ��� ���� p614. ��ũ�� ���� �� 
public class EnumerationDemo {
	public static void main(String[] args) {
		//��ũ�� ���� �� 
		Stack<String> stack = new Stack<String>();
		String [] array = {"������", "������", "������", "������", "ȫ����"};
		
		for(String str : array)  stack.push(str); //stack���� �־���
		Enumeration<String> enums = stack.elements();
		while(enums.hasMoreElements()) 
			System.out.println(enums.nextElement());
			//�÷����� Ÿ��(stack, queue ��) ���� �����ϰ� ��ũ�� ���´�.
		System.out.println("-----------");
		
		Queue<String> queue = new LinkedList<String>();
		for(String str : array)  queue.offer(str);
		Iterator<String> iters = queue.iterator();
		while(iters.hasNext()) System.out.println(iters.next());
	}
}


