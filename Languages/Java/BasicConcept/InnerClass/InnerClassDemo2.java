/*
 * Local Inner Class ���� ���� Ŭ����
 * 1. Why?
 * 2. How to create : �����ִ� �޼ҵ尡 ����Ǿ��
 * 3. Restricted Point : 1) �޼ҵ� �ȿ����� ������. �������̴�. Ŭ���� ���� �� �����ؾ�. 2) ����Ŭ�������� ����������(public, private, protected) ���Ұ�
 *///3) static ��� �Ұ� ��. ���������� �� �Ȱ���. 
 /*�� ���� ������������ abstract �� ��������, ����Ŭ�������� �����ϴ�.
  * 4) static variable, static method�� �����Ұ�
  * 
  */

public class InnerClassDemo2 {
	public static void main(String[] args) {
		int kor = 100;
		LocalOuterClass outer = new LocalOuterClass();
		outer.display();
	}
}


class LocalOuterClass{
	public void display() { //�� �޼��尡 ������ ������� age = 50 ���� ����ǰ� ����~!
		int age = 50; //local variable //������������ access modifier�� ���δ�. ����Ŭ������ ��������.
		class LocalInnerClass{//Ŭ������ �޼��� ��!(display()�޼��� �ȿ� �ִ� ����) = ����Ŭ����, ���� �޼��尡 ������ �����.
			private int kor = 90;
			private static int eng = 100;
			private static void print() {
				System.out.println("���� ����Ŭ������ �޼ҵ�");
			}
		}
		
//		LocalInnerClass inner = new LocalInnerClass(); 		
//		class LocaInnerClass{}							//�̷��� ���� �ȵȴ�. ������ �߸���. �޼���� �������ε�, LocalInnerClass�� �б⵵ ���� new~�ּҸ� ������ ���� ����. �� ������.
		}
	}





