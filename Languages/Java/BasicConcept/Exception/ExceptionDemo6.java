

//callstack �̶�� �Ѵ�.
public class ExceptionDem6 {
	public static void main(String[] args) {
		a();
	}
	
	static void a() {
		try {
		b();
		}catch(Exception e) {
			System.out.println("���⼭ �����");
		}
		
	}
	
	
	static void b() throws RuntimeException { 
		c();
	}
	static void c() throws RuntimeException {
		d();
	}
	static void d() throws RuntimeException{ //
		System.out.println(5/0);  //exception�߻�. d�޼ҵ尡 exception�� ������. ��������? ���� ȣ���� ��(C). 
//		C�� B����, B�� A���� . ���� �ذ��� �ȵǴϱ� ������ ����. A�� ���ο��� ����. ���ε� �ذ�ȵ�. �׷��� ������ VM(virtual machine)�� ����
		//�׷��� exception�� �߰����� ������ �ȴ�. �׷��� a�뿡�� try catch�� ���� ����.
	}
}


