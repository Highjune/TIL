/*
 * Instance Inner Class
 * 1. Why? : �������� �δ�(�ǹ�)���� ���߻���Ϸ���
 * 2. How to create : �ٱ� Ŭ������ �ּҸ� ���ؼ� ����.
 * 3. restricted Point : static ����, static method�� ���� �� ����. 
 * 
 */
public class InnerClassDemo {
	public static void main(String[] args) {
		InstanceOuter outer = new InstanceOuter();
		int age = outer.age;
		InstanceOuter.InstanceInner inner = outer.new InstanceInner();  // �ּ�.������
		
	}
}
class InstanceOuter{
	int age = 24; // �ٱ�Ŭ������ �������	
	static int kor = 100; //�ٱ�Ŭ������ ����ƽ����
	class InstanceInner{//�ٱ�Ŭ������ ����ƽ����  //���Ŭ����!   //���ʿ� �ִ� Ŭ������ private�� �ȴ�.
		int eng = 90;
//		static int mat = 70; // ���� Ŭ������ static�� ���� �� ����.
		public InstanceInner( ) { //���� Ŭ������ ������
			System.out.println("���� Ŭ������ ��� �����ƽ��ϴ�."); 
		}
		public void display() {  //���� ������ ����̹Ƿ� static�� ���� �� ����.
			System.out.println(age);
		}
	}
}
//		
//	}
//	
//}










//public class InnerClassDemo {
//	public static void main(String[] args) {
//		InstanceOuter outer = new InstanceOuter();
//		int age = outer.age;
//		InstanceOuter.InstanceInner inner = outer.new InstanceInner();  // �ּ�.������
//		
//	}
//}
//class InstanceOuter extends Car{
//	int age = 24; // �ٱ�Ŭ������ �������	
//	static int kor = 100; //�ٱ�Ŭ������ ����ƽ����
//	class InstanceInner extends Sonata{//�ٱ�Ŭ������ ����ƽ����  //���Ŭ����!   //���ʿ� �ִ� Ŭ������ private�� �ȴ�.
//		int eng = 90;
////		static int mat = 70; // ���� Ŭ������ static�� ���� �� ����.
//		public InstanceInner( ) { //���� Ŭ������ ������
//			System.out.println("���� Ŭ������ ��� �����ƽ��ϴ�."); 
//		}
//		public void display() {
//			
//			System.out.println(bgcolor);  //�ٱ��� Ŭ������ �θ�Ե� ���ٰ����ϴ�. 
//			System.out.println(price);  //�ٱ��� Ŭ������ �θ�Ե� ���ٰ����ϴ�. 
//		}//�ٱ��� ���� ����, �ٱ����� �θ�Ե� ���ٰ���, ���� ����, ���� �θ� ����. // �� 4�� Ŭ���� �� ���ٰ���.
//	
//	}
//	
//}
//
//class Car{
//	int price = 25_000_000; //CarŬ������ �������
//}
//
//class Sonata{
//	String bgcolor = "Silver";	
//}
//









