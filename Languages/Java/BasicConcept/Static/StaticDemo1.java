
//public class StaticDemo1 {
//	static int age = getAge();  //���� ���� �޸𸮿� �ö�´�. �׷��� ������ getAge�� �ڵ�ȣ��
//	public static void main(String[] args) {
//		System.out.println("���� ���� �޼ҵ�"); 
//		System.out.println("age = " + age );
//	}
//	
//	static int getAge() {
//		System.out.println("���� ����ƽ �޼ҵ�");
//		return 24;
//	}
//}


////////  2. static method : �ּҾ��� �޼ҵ� �����Ϸ���


public class StaticDemo1 {
	
	static int age = getAge();  //���� ���� �޸𸮿� �ö�´�. �׷��� ������ getAge�� �ڵ�ȣ��
	public static void main(String[] args) { //������ �� Static ?? => �ּ� ���� �����ϱ� ���ؼ�
//		Tiger tiger = new tiger();
//		Tiger.name
		System.out.println("���� ���� �޼ҵ�");
		System.out.println("age = " + age);
	}
	
	static int getAge() {
		StaticDemo1 sd = new StaticDemo1();
		System.out.println("���� ����ƽ �޼ҵ�");
		return 24;
	}
	
}

class Tiger{
	private Tiger() {} //private���̸� �ٸ� ������ new�� �� �����. �׷��� static!!!!!!!!
	static String name = "Sally";
}

