/*
 * static Inner Class
 * 1. Why ? Packaging �Ϸ��� ����.  ex) ���ﵿ�� ���￡���� ������ ���ν� ���ﵿ�� �ֱ� ������.
 * 2. How to create : �ٱ� Ŭ������ �ּҰ� �ʿ����� �ʴ�. �ٱ�Ŭ�����̸����� ����
 * 3. Restricted Point : �ٱ� Ŭ������ ��������� ����޼ҵ� ���� �Ұ� (��? ���� static�̴ϱ�)
 * 
 */


public class InnerClassDemo1 {
	public static void main(String[] args) {
		int age = StaticOuter.age;
		StaticOuter.StaticInner inner = new StaticOuter.StaticInner();  //�ٱ��� Ŭ������ ���� �ʿ� ����. ���⼭ new�� StaticInner()�� ���� ��.
	}
}


class StaticOuter{ //�ٱ��� ��� Ŭ�������� private�� �ȵǰ� static�� �� �ȴ�. ��� Ŭ������ public�� �ƹ��͵� �� ���� �͸� �����ϴ�.
	static int age = 24;
	int kor = 100; // kor�� �޸𸮿� �ö󰡾߸� ���ٰ����ϴ�. �׷��� �޸𸮿� �ö󰡷��� �ּҸ� �����ؾ� �Ǵµ�, �ּҸ� ���� ���߱� ������ ������ �ȵȴ�.
		static class StaticInner{ 
		//����Ŭ������ ���� Ŭ������ static �� ���� �� �ִ�.
			int eng = 100;
			public void StaticInner() {System.out.println("��� ����ƽ ��ü�� �����ƽ��ϴ�.");}
			public void display() {
//			System.out.println(age); // �ٱ��� ���ٰ���.
//			System.out.println(eng); // ����ϱ� ���� �����ϴ�.
			}
		}
}	



