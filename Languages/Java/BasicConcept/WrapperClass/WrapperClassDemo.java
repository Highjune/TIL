//�ڹ� 1.4�������� �Ʒ��� ���� ����.
//public class WrapperClassDemo {
//	public static void main(String[] args) {
//		int age = 24;//primitive type�̹Ƿ� stack�� �ִ�.
//		Integer in = new Integer(age); //Wrapping, boxing//heap�� ����. heap�� �� �ּҸ� in�� �����ϰ� ����.
//		//api���� lang - integer ���� integer�� ������Ȯ���ϸ� ()�ȿ� int����
//		
//		int number = in.intValue(); //unwrapping, unboxing
//		System.out.println("number = " + number);
//		
//	}
//}


//�ڹ� ���� �� ���ķδ� �Ʒ��� ����.
//Autoboxing!!!

public class WrapperClassDemo {
	public static void main(String[] args) {
		int age = 24;//primitive type�̹Ƿ� stack�� �ִ�.
		
		Integer in = age + 100; // new Integer(24+100); // autoboxing(heap�� ���� �� �ڵ����� ����)
		//new�� �ț��µ��� ����X. ����� �ӽ��� ������ش�.
		
		int number = in;	//in.intValue();�� ������ ����. autounboxing (stack�� �Ѿ�� �� �ڵ����� ����)
		//���������� �ּҰ� number�� ���� ���� �ƴ�. 
		
		
		System.out.println("number = " + number);
		
	}
}











