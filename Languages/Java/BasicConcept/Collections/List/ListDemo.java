//�ڷᱸ����.�����͸� stack������� ������ ���ΰ�, �ƴϸ� queue�� �� ���ΰ�. 

import java.util.Vector;

public class ListDemo {
	public static void main(String[] args) {
		
//		Queue<String> queue = new LinkedList<String>();
//		String[] array = {"������", "������", "������", "�ڼ���", "�㰭��"};
//		for(String str : array) queue.offer(str);
////		System.out.println(queue.peek());  //queue�� stack�� �ٸ���. queue�� �������ϱ� ���� ���� ���� ���� ������.
//		System.out.println(queue.poll());  //poll�� queue�� �Ȱ���. ������
//		System.out.println(queue.poll());  //poll�� queue�� �Ȱ���. ������
//		System.out.println(queue.poll());  //poll�� queue�� �Ȱ���. ������
//		System.out.println(queue.poll());  //poll�� queue�� �Ȱ���. �ڼ���
//		System.out.println(queue.poll());  //poll�� queue�� �Ȱ���. �㰭��
//		System.out.println(queue.poll());  //poll�� queue�� �Ȱ���. //���⼭���� null�� ���´�. �̹� �� �������ϱ�.
//		System.out.println(queue.poll());  //poll�� queue�� �Ȱ���.
//		System.out.println(queue.poll());  //poll�� queue�� �Ȱ���.

			//stack�� push pop, collection�� add remove, queue�� offer poll
		
//		LinkedList<Object> obj = new LinkedList<String>(); �̷� ����ȯ�� �ȵȴٴ� ������ ��ó���� �����ϴ�.
		
//		ArrayList<String> list = new ArrayList<String>();
//		String[] array = {"������", "������", "������", "������", "������"}; // 0 1 2 3 4 
//		for(String str : array) list.add(str);  // �������� add. ���� ���� get
//		System.out.println(list.get(2));
		
		///Vector - arraylist���� �ξ� �� ȿ������
		///vector �����ڿ��� �Ķ������ capacityincrement�� ������������. ���� �þ������ ���������ŭ ������.
		
		//ex)������� 5�� �����Դϴ� - �迭�ε� ����� ������, ����� ���Ѿ��� - �迭�δ� ���� �Ұ���, �÷����� �� �� �ۿ� ����.
		//
		
		Vector <String> vector = new Vector <String> (5,3); // �ʱ������ 5��, ���������� 3�� . 5���� �� á�� �� 1���� �� ������ �� 3���� ����
		String[] array = {"������", "������", "������", "������", "������"};
		for(String str : array) vector.add(str);
		System.out.println("capacity = " + vector.capacity());
		System.out.println("size = " + vector.size());
		vector.add("������");
		System.out.println("capacity = " + vector.capacity()); //1�� �� ���Ӵµ� ���� 3���� �þ.
		System.out.println("size = " + vector.size());  
		//��� �ӵ��� ����.
	}
}






