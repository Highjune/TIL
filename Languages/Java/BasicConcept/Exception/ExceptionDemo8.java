public class ExceptionDemo4 {
	public static void main(String[] args) {
//		int su = Integer.parseInt("54"); // "54" --> 54  ������ ���ڸ� ���ڷ� 
//		int su = Integer.parseInt("54cm"); // cm ������ exception �߻�
//		System.out.printf("su = %d\n", su);
//		
		
		Bumo bumo = new Jasik(); 
		bumo.display();
		
	}
}


class Bumo{
	public void display() throws java.io.FileNotFoundException{ //FileNotFoundException�� IOException(API���� �θ�)���� ������ ���Ƽ� ����������.
		System.out.println("���� �θ��� �޼ҵ�");}
}

class Jasik extends Bumo{
	@Override
//	public void display() {System.out.println("���� �θ��� �޼ҵ�");} //���
	public void display() throws java.io.IOException /*, java.sql.SQLExceptioni*/ {   
		System.out.println(5/0);
//runtimeexception�� ��쿡�� �̷��� �ᵵ �ȴ�user�� �� ���⸸ �ϸ� �� ���.(�ڽ�, �θ��� ����� ����)
//��ſ� �ݵ�� try catch ��� �Ǵ� checked exception�� �� ���� �θ� �ڽ� ���� �����ؾ� �ȴ�.
//�θ�� ������ϰ� ���� �����ϸ� ��������.(checked exception��) ����, ���� �� �����ؾ� �ȴ�.
//���ܰ����� ���ų�(å������ ������ ����), ����(���� ���� �ȿ��� �θ�-�ڽ�) �ȿ����� �����μ��� �θ� �� �о�� �ȴ�.
//�ٵ� �ڽ��� �� �о �������� ����.
	
	}
}

