public class HelloWorld3 {
	public static void main(String[] args) {
		Test t = new Test(); 
		System.out.println(t.msg);
//		System.out.println(new Test().msg); // �̷��� �ص� �ȴ�
	
	}

}
class Test{
	String msg ="Hello, World"; //�������(Ŭ���� �ȿ� �ִµ� static�� ������ ���, �׸��� �ٸ� ��(��)���� �ҷ������� �����ؾ� �ȴ� new~)
}






