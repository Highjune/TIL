/*
 * Anonymous Inner Class
 * 1. Why? : ��ȸ�� / Ư��Ŭ������ ����޼ҵ� ������
 * 2. how to create : �����ִ� �޼ҵ尡 ȣ����� ��
 * 3. Restricted Point 
 * cf) �̸��� ���� ���� �ƴ϶� ������ Ŭ������ ������ �Ϸ���
 */


public class InnerClassDemo3 {
	public static void main(String[] args) {
//		jimin.display(); ���� ���� ������. �ֳ��ϸ� �޼ҵ�� �������̹Ƿ�.
		Employee jimin = new Employee() {
			@Override
			public void display() {
				System.out.println("���� �ڽ� �޼ҵ�");   //����� ���� �ʾƵ� �������� �� �ִ�. �޼ҵ� �ȿ��� �����ǵǾ��� ������ ����Ŭ����.
			}
		};  // ������ ��. �ϳ��� �����̴�!!
		jimin.display();
	}
}


class Employee{
	public void display() {
		System.out.println("���� �θ� �޼ҵ�");
	}
}

